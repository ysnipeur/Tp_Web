package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

import Models.Projet;


public class ProjetDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/g8_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	private static final String INSERT_PROJECTS_SQL = "INSERT INTO projet" + "  (code_proj, lib_proj, budget_proj, type_proj, avancement, statut, etat, date_debut, date_fin, id_utilisateur) VALUES "
													+ " (?, ? , ? , ? , ?, ?, ?, ?, ?, ?);";

	private static final String SELECT_PROJET_BY_ID = "select * from projet where code_proj =?"; // recupère un projet donner
	private static final String SELECT_ALL_PROJECTS_AFFECTER = "select * from projet where id_utilisateur <> ? ; "; // utiliser par le super Admin
	private static final String SELECT_ALL_PROJECTS_NON_AFFECTER = "select * from projet where id_utilisateur = ? ; "; // utiliser par le super Admin
	private static final String SELECT_ALL_PROJETS_BY_ADMINS = "select * from projet where id_utilisateur = ? and etat = ?;"; // utiliser par les Admins
	private static final String ANNULER_PROJET_SQL = "update projet set statut = ?, etat = ? where code_proj = ? ;";
	
	private static final String SUSPENDRE_PROJET_SQL = "update projet set statut = ? where code_proj = ? ;"; // Suspendre un projet donner
	private static final String TERMINER_PROJET_SQL = "update projet set statut = ?, etat = ?, avancement = ? where code_proj = ? ;"; // Terminer un projet donner
	private static final String DEMARER_PROJET_SQL = "update projet set statut = ? where code_proj = ? ;";
	
	private static final String AFFECTER_PROJET_SQL = "update projet set id_utilisateur = ? where code_proj = ? ;";
	
	private static final String RETIRER_PROJET_SQL = "update projet set id_utilisateur = ? where code_proj = ? and id_utilisateur = ? ;";
	
	private static final String UPDATE_PROJET_SQL = "update projet set   lib_proj= ?, type_proj = ?, avancement = ?, date_fin = ?, budget_proj = ?, statut = ?, id_utilisateur = ?, etat = ?  where code_proj = ? ;";
	
	

	
	public ProjetDAO() {
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

	// Méthode pour insérer un nouveau projet dans le système
	
	public void insertProjet(Projet projet, int id_utilisateur) throws SQLException {
		
		// déclaration try-with-resource fermera automatiquement la connexion.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROJECTS_SQL)) {
			preparedStatement.setString(1, projet.getCode_projet());
			preparedStatement.setString(2, projet.getLib_proj());
			preparedStatement.setInt(3, projet.getBudget_proj());
			preparedStatement.setString(4, projet.getType_projet());
			preparedStatement.setInt(5, projet.getAvancement());
			preparedStatement.setString(6, projet.getStatut());
			preparedStatement.setBoolean(7, projet.isEtat());
			preparedStatement.setObject(8, projet.getDate_debut());
			preparedStatement.setObject(9, projet.getDate_fin());
			
			preparedStatement.setInt(10, id_utilisateur);
			
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	
	// Méthode pour annuler un projet, cela implique qu'il n'est plus visible par les roles utilisateurs et admin
	
	public boolean AnnulerProjet(String code_proj) throws SQLException {
		boolean rowAnnuler;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(ANNULER_PROJET_SQL);) {
			
			statement.setString(1, "Annuler");
			statement.setInt(2, 0);
			statement.setString(3, code_proj);
			
			rowAnnuler = statement.executeUpdate() > 0;
			
		}
		return rowAnnuler;
	}
	
	// Méthode pour SUSPENDRE un projet
	
	public boolean SuspendreProjet(String code_proj) throws SQLException {
		boolean rowSuspendu;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(SUSPENDRE_PROJET_SQL);) {
			
			statement.setString(1, "Suspendu");
			statement.setString(2, code_proj);
			
			rowSuspendu = statement.executeUpdate() > 0;
			
		}
		return rowSuspendu;
	}
	
	// Méthode qui permet de mentioner qu'un projet est terminer
	
	public boolean TerminerProjet(String code_proj) throws SQLException {
		boolean rowTerminer;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(TERMINER_PROJET_SQL);) {
			
			statement.setString(1, "Terminer");
			statement.setInt(2, 0);
			statement.setInt(3, 100);
			statement.setString(4, code_proj);
			
			rowTerminer = statement.executeUpdate() > 0;
			
		}
		return rowTerminer;
	}
	
	// Méthode qui permet de mentioner qu'un projet est démarer
	
		public boolean DemarerProjet(String code_proj) throws SQLException {
			boolean rowDemarer;
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(DEMARER_PROJET_SQL);) {
				
				statement.setString(1, "En cours");
				statement.setString(2, code_proj);
				
				rowDemarer = statement.executeUpdate() > 0;
				
			}
			return rowDemarer;
		}
	
		// Méthode qui permet d'affecter un projet un role admin
		
		public boolean AffecterProjet(String code_proj, int idAdmin) throws SQLException {
			boolean rowAffecter;
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(AFFECTER_PROJET_SQL);) {
				
				statement.setInt(1, idAdmin);
				statement.setString(2, code_proj);
				
				rowAffecter = statement.executeUpdate() > 0;
				
			}
			return rowAffecter;
		}
		
		// Méthode qui permet de mentioner qu'un projet est terminer
		
		public boolean RetirerProjet(String code_proj, int ancienAdmin, int nouvelAdmin) throws SQLException {
			boolean rowRetirer;
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(RETIRER_PROJET_SQL);) {
				
				statement.setInt(3, ancienAdmin);
				statement.setInt(1, nouvelAdmin);
				statement.setString(2, code_proj);
				
				rowRetirer = statement.executeUpdate() > 0;
				
			}
			return rowRetirer;
		}
	
	// Méthode pour récupérer les informations d'un utilisateur donner par son id
	
	public Projet selectProjet(String code_projet) {
		Projet projet = null;
		// Étape 1: Établissement d'une connexion
		try (Connection connection = getConnection();
				// Étape 2: Créer une déclaration à l'aide d'un objet de connexion
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PROJET_BY_ID);) {
			preparedStatement.setString(1, code_projet);
			System.out.println(preparedStatement);
			// Étape 3: Exécuter la requête ou mettre à jour la requête
			ResultSet rs = preparedStatement.executeQuery();

			// Étape 4: Traitez l'objet ResultSet.
			while (rs.next()) {
				String lib_proj = rs.getString("lib_proj");
				int budget = rs.getInt("budget_proj");
				String type_proj = rs.getString("type_proj");
				int avancement = rs.getInt("avancement");
				String statut = rs.getString("statut");
				boolean etat = rs.getBoolean("etat");
				Timestamp dateDebut = rs.getTimestamp("date_debut");
				
				Timestamp dateFin = rs.getTimestamp("date_fin");
				
				
				
				projet = new Projet(code_projet, lib_proj, budget, type_proj, avancement, statut, etat, dateDebut, dateFin);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return projet;
	}
	
	// Méthode qui renvoie tous les projets qui sont déjà affecter à un role admin
	
	public List<Projet> selectAllProjetsAffecter() {

		// utilisation de ressources d’essai pour éviter la fermeture de ressources (code de plaque de chaudière)
		List<Projet> projetsAffecter = new ArrayList<>();
		// Étape 1: Établissement d'une connexion
		try (Connection connection = getConnection();

				// Étape 2: Créer une déclaration à l'aide d'un objet de connexion
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PROJECTS_AFFECTER);) {
			preparedStatement.setInt(1, 0);
			
			// Étape 3: Exécuter la requête ou mettre à jour la requête
			ResultSet rs = preparedStatement.executeQuery();

			// Étape 4: traiter l'objet ResultSet.
			while (rs.next()) {
				
				String code_proj = rs.getString("code_proj");
				String lib_proj = rs.getString("lib_proj");
				int budget = rs.getInt("budget_proj");
				String type_proj = rs.getString("type_proj");
				int avancement = rs.getInt("avancement");
				int id_utilisateur = rs.getInt("id_utilisateur");
				String statut = rs.getString("statut");
				boolean etat = rs.getBoolean("etat");
				Timestamp dateDebut = rs.getTimestamp("date_debut");
				
				Timestamp dateFin = rs.getTimestamp("date_fin");
				
				projetsAffecter.add(new Projet(id_utilisateur,code_proj, lib_proj, budget, type_proj, avancement, statut, etat, dateDebut, dateFin));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		
		
		return projetsAffecter;
	}
	
	// Méthode qui renvoie tous les projets qui ne sont pas encore affecter à un role admin
	
		public List<Projet> selectAllProjetsNonAffecter() {

			// utilisation de ressources d’essai pour éviter la fermeture de ressources (code de plaque de chaudière)
			List<Projet> projetsAffecter = new ArrayList<>();
			// Étape 1: Établissement d'une connexion
			try (Connection connection = getConnection();

					// Étape 2: Créer une déclaration à l'aide d'un objet de connexion
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PROJECTS_NON_AFFECTER);) {
				preparedStatement.setInt(1, 0);
				
				// Étape 3: Exécuter la requête ou mettre à jour la requête
				ResultSet rs = preparedStatement.executeQuery();

				// Étape 4: traiter l'objet ResultSet.
				while (rs.next()) {
					
					String code_proj = rs.getString("code_proj");
					String lib_proj = rs.getString("lib_proj");
					int budget = rs.getInt("budget_proj");
					String type_proj = rs.getString("type_proj");
					int avancement = rs.getInt("avancement");
					String statut = rs.getString("statut");
					boolean etat = rs.getBoolean("etat");
					Timestamp dateDebut = rs.getTimestamp("date_debut");
					
					Timestamp dateFin = rs.getTimestamp("date_fin");
					
					projetsAffecter.add(new Projet(code_proj, lib_proj, budget, type_proj, avancement, statut, etat, dateDebut, dateFin));
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			
			
			return projetsAffecter;
		}
		
		
		// Méthode qui renvoie tous les projets d'un admin qui ne sont pas encore terminer ou annuler
		
			public List<Projet> selectAllProjetsOfAdmin(int idAdmin) {

				// utilisation de ressources d’essai pour éviter la fermeture de ressources (code de plaque de chaudière)
				List<Projet> projetsAffecter = new ArrayList<>();
				// Étape 1: Établissement d'une connexion
				try (Connection connection = getConnection();

						// Étape 2: Créer une déclaration à l'aide d'un objet de connexion
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PROJETS_BY_ADMINS);) {
					
					preparedStatement.setInt(1, idAdmin);
					preparedStatement.setInt(2, 1);
					
					// Étape 3: Exécuter la requête ou mettre à jour la requête
					ResultSet rs = preparedStatement.executeQuery();

					// Étape 4: traiter l'objet ResultSet.
					while (rs.next()) {
						
						String code_proj = rs.getString("code_proj");
						System.out.println("code_proj : " + code_proj);
						
						String lib_proj = rs.getString("lib_proj");
						int budget = rs.getInt("budget_proj");
						String type_proj = rs.getString("type_proj");
						int avancement = rs.getInt("avancement");
						String statut = rs.getString("statut");
						boolean etat = rs.getBoolean("etat");
						Timestamp dateDebut = rs.getTimestamp("date_debut");
						
						System.out.println("dateDebut : " + dateDebut);
						
						Timestamp dateFin = rs.getTimestamp("date_fin");
						
						System.out.println("dateFin : " + dateFin);
						
						projetsAffecter.add(new Projet(code_proj, lib_proj, budget, type_proj, avancement, statut, etat, dateDebut, dateFin));
					}
				} catch (SQLException e) {
					printSQLException(e);
				}
				
				
				return projetsAffecter;
			}
			
		
	
	
	// Méthode qui permet à un role super Admin de modifier les informations sur un projet
	
		public boolean updateProjetInfos(int id_utilisateur, String code_projet, String intitule, int budget, int avancement, String statut, String type, boolean etat, Timestamp endDate) throws SQLException {
			
			boolean rowUpdated;
			
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(UPDATE_PROJET_SQL);) {
				
				statement.setString(1, intitule);
				
				statement.setString(2, type);
				
				statement.setInt(3, avancement);
				
				statement.setTimestamp(4, endDate);
				
				statement.setInt(5, budget);
				
				statement.setString(6, statut);
				
				statement.setInt(7, id_utilisateur);
				
				statement.setBoolean(8, etat);
				
				statement.setString(9, code_projet);
				
				
				rowUpdated = statement.executeUpdate() > 0;
				
			}
			
			return rowUpdated;
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
