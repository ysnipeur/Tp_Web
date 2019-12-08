package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.Utilisateur;

public class UserDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/g8_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	private static final String INSERT_USERS_SQL = "INSERT INTO utilisateur" + "  (nom, prenom, fonction, login, pwd, role, statut, isFirstConnection, createdBy) VALUES "
											+ " (?, ? , ? , ? , ?, ?, ?, ?, ?);";
	
	private static final String SELECT_USER = "select id, login, pwd, isFirstConnection from utilisateur where login =? and pwd= ?";
	
	private static final String SELECT_USER_BY_ID = "select * from utilisateur where id =?";
	private static final String SELECT_ALL_USERS = "select * from utilisateur"; // utiliser par le super Admin
	private static final String SELECT_ALL_USERS_BY_ADMINS = "select * from utilisateur where createdBy = ?"; // utiliser par les Admins
	private static final String DESACTIVATE_USER_SQL = "update utilisateur set statut = ? where id = ? ;";
	private static final String ACTIVATE_USER_SQL = "update utilisateur set statut = ? where id = ? ;";
	
	private static final String UPDATE_USER_PWD_SQL = "update utilisateur set pwd= ?, isFirstConnection = ? where id = ?;";
	
	private static final String UPDATE_USER_INFO_SQL = "update utilisateur set nom= ?, prenom= ?, pwd= ? where id = ?;";
	
	private static final String UPDATE_USER_ROLE_FONCTION_SQL = "update utilisateur set fonction= ? where id = ?;";
	
	
	public UserDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return connection;
	}

	// M�thode pour ins�rer un nouvel utilisateur dans le syst�me
	
	public void insertUser(Utilisateur user) throws SQLException {
		
		// d�claration try-with-resource fermera automatiquement la connexion.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getNom());
			preparedStatement.setString(2, user.getPrenom());
			preparedStatement.setString(3, user.getFonction());
			preparedStatement.setString(4, user.getLogin());
			preparedStatement.setString(5, user.getPwd());
			preparedStatement.setInt(6, user.isRole());
			preparedStatement.setBoolean(7, user.isStatut());
			preparedStatement.setBoolean(8, user.isFirstConnection());
			preparedStatement.setInt(9, user.getCreatedBy());
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	
	// M�thode pour activer le compte d'un utilisateur
	
	public boolean ActivateUser(int id) throws SQLException {
		boolean rowActivated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(ACTIVATE_USER_SQL);) {
			statement.setInt(1, 1);
			statement.setInt(2, id);
			rowActivated = statement.executeUpdate() > 0;
		}
		return rowActivated;
	} 
	
	// M�thode pour d�sactiver le compte d'un utilisateur
	
	public boolean DesactivateUser(int id) throws SQLException {
		boolean rowDesactivated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DESACTIVATE_USER_SQL);) {
			statement.setInt(1, 0);
			statement.setInt(2, id);
			rowDesactivated = statement.executeUpdate() > 0;
		}
		
		return rowDesactivated;
	}
	
	// M�thode pour r�cup�rer les informations d'un utilisateur donner par son id
	
	public Utilisateur selectUser(int id) {
		Utilisateur user = null;
		// �tape 1: �tablissement d'une connexion
		try (Connection connection = getConnection();
				// �tape 2: Cr�er une d�claration � l'aide d'un objet de connexion
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// �tape 3: Ex�cuter la requ�te ou mettre � jour la requ�te
			ResultSet rs = preparedStatement.executeQuery();

			// �tape 4: Traitez l'objet ResultSet.
			while (rs.next()) {
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String fonction = rs.getString("fonction");
				String login = rs.getString("login");
				String pwd = rs.getString("pwd");
				int role = rs.getInt("role");
				boolean statut = rs.getBoolean("statut");
				boolean isFirstConnection = rs.getBoolean("isFirstConnection");
				int createdBy = rs.getInt("createdBy");
				user = new Utilisateur(id,nom, prenom, fonction, login, pwd, role, statut, isFirstConnection, createdBy);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}
	
	// M�thode qui renvoie tous les utilisateurs sous la demande du super admin
	
	public List<Utilisateur> selectAllUsers() {

		// utilisation de ressources d�essai pour �viter la fermeture de ressources (code de plaque de chaudi�re)
		List<Utilisateur> users = new ArrayList<>();
		// �tape 1: �tablissement d'une connexion
		try (Connection connection = getConnection();

				// �tape 2: Cr�er une d�claration � l'aide d'un objet de connexion
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			
			System.out.println(preparedStatement);
			// �tape 3: Ex�cuter la requ�te ou mettre � jour la requ�te
			ResultSet rs = preparedStatement.executeQuery();

			// �tape 4: traiter l'objet ResultSet.
			while (rs.next()) {
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String fonction = rs.getString("fonction");
				String login = rs.getString("login");
				String pwd = rs.getString("pwd");
				int role = rs.getInt("role");
				boolean statut = rs.getBoolean("statut");
				boolean isFirstConnection = rs.getBoolean("isFirstConnection");
				int createdBy = rs.getInt("createdBy");
				
				users.add(new Utilisateur(id,nom, prenom, fonction, login, pwd, role, statut, isFirstConnection, createdBy));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}
	
	// M�thode qui renvoie tous les utilisateurs d'un admin donner � partir de son id
	
	public List<Utilisateur> selectAllUsersCreatedByAdmin(int idAdmin) {

		// utilisation de ressources d�essai pour �viter la fermeture de ressources (code de plaque de chaudi�re)
		List<Utilisateur> users = new ArrayList<>();
		// �tape 1: �tablissement d'une connexion
		try (Connection connection = getConnection();

				// �tape 2: Cr�er une d�claration � l'aide d'un objet de connexion
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS_BY_ADMINS);) {
			preparedStatement.setInt(1, idAdmin);
			System.out.println(preparedStatement);
			// �tape 3: Ex�cuter la requ�te ou mettre � jour la requ�te
			ResultSet rs = preparedStatement.executeQuery();

			// �tape 4: traiter l'objet ResultSet.
			while (rs.next()) {
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String fonction = rs.getString("fonction");
				String login = rs.getString("login");
				String pwd = rs.getString("pwd");
				int role = rs.getInt("role");
				boolean statut = rs.getBoolean("statut");
				boolean isFirstConnection = rs.getBoolean("isFirstConnection");
				
				int createdBy = rs.getInt("createdBy");
				
				users.add(new Utilisateur(id,nom, prenom, fonction, login, pwd, role, statut, isFirstConnection, createdBy));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	// M�thode qui permet � un utilisateur de modifier son mot de passe
	
	public boolean updateUserPassword(int idUser, String pwd) throws SQLException {
		
		boolean rowUpdated;
		
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USER_PWD_SQL);) {
			
			statement.setString(1, pwd);
			
			statement.setInt(2, 0);
			
			statement.setInt(3, idUser);
			
			rowUpdated = statement.executeUpdate() > 0;
			
		}
		
		return rowUpdated;
	}
	
	// M�thode qui permet � un utilisateur de modifier ses informations
	
		public boolean updateUserInfos(Utilisateur user) throws SQLException {
			
			boolean rowUpdated;
			
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(UPDATE_USER_INFO_SQL);) {
				
				statement.setString(1, user.getNom());
				
				statement.setString(2, user.getPrenom());
				
				statement.setString(3, user.getPwd());
				
				statement.setInt(4, user.getId());
				
				rowUpdated = statement.executeUpdate() > 0;
				
			}
			
			return rowUpdated;
		}
		
		// M�thode qui permet � un admin et un super admin de modifier le role et la fonction d'un utilisateur
		
	public boolean updateUserRoleFonction(String fonction, int id) throws SQLException {
		
		boolean rowUpdated;
		
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USER_ROLE_FONCTION_SQL);) {
			
			statement.setString(1, fonction);
			
			statement.setInt(2, id);
			
			rowUpdated = statement.executeUpdate() > 0;
			
		}
		
		return rowUpdated;
	}
	
	// M�thode qui permet d'authentifier un utilisateur du system � partir de son login et mot de passe
public Utilisateur authentificate(String login, String pwd) {
		
		ResultSet rs;
		
		Utilisateur userConnected = null;
		
		boolean userExist = false ;
		// �tape 1: �tablissement d'une connexion
		try (Connection connection = getConnection();
				// �tape 2: Cr�er une d�claration � l'aide d'un objet de connexion
				PreparedStatement statement = connection.prepareStatement(SELECT_USER);) {
			statement.setString(1, login);
			statement.setString(2, pwd);
			
			
			// �tape 3: Ex�cuter la requ�te ou mettre � jour la requ�te
			rs = statement.executeQuery();
			
			userExist = rs.next();
			
			if(userExist)
			{
				int id = rs.getInt("id");
				
				userConnected = selectUser(id);
				
			}

			
		} catch (SQLException e) {
			printSQLException(e);
		}
		
		return userConnected;
		
	}


	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
