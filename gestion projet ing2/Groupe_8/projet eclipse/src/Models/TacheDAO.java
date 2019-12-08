package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

import sun.text.CodePointIterator;


public class TacheDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/g8_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	private static final String INSERT_TACHE_SQL = "INSERT INTO tache" + "  (code_tc, design_tc, coutunit_tc,code_proj ,avancement, statut, etat, date_debut, date_fin, id_utilisateur) VALUES "
													+ " (?, ? , ? , ? , ?, ?, ?, ?, ?, ?);";

	private static final String SELECT_TACHE_BY_ID = "select * from tache where code_tc =?"; // recupère un tache donner
	private static final String SELECT_ALL_TACHE_AFFECTER = "select * from tache where id_utilisateur != ? ; "; // utiliser par le super Admin et l'Admin
	private static final String SELECT_ALL_TACHE_NON_AFFECTER = "select * from tache where id_utilisateur = ? ; "; // utiliser par le super Admin et l'admin
	private static final String SELECT_ALL_TACHE_BY_USERS = "select * from tache where id_utilisateur = ? and etat = ?;"; // utiliser par les Admins
	
	private static final String SELECT_ALL_TACHE_BY_PROJECT_AFFECTER = "select * from tache where code_proj = ? and id_utilisateur <>  ?;"; // Les tâches d'un projet donner
	
	private static final String SELECT_ALL_TACHE_BY_PROJECT_NON_AFFECTER = "select * from tache where code_proj = ? and id_utilisateur = ?;"; // Les tâches d'un projet donner
	
	private static final String ANNULER_TACHE_SQL = "update tache set statut = ?, etat = ? where code_tc = ? ;";
	private static final String SUSPENDRE_TACHE_SQL = "update tache set statut = ? where code_tc = ? ;";
	private static final String TERMINER_TACHE_SQL = "update tache set statut = ?, etat = ?, avancement = ? where code_tc = ? ;";
	private static final String DEMARER_TACHE_SQL = "update tache set statut = ? where code_tc = ? ;";
	
	private static final String AFFECTER_TACHE_SQL = "update tache set id_utilisateur = ? where code_tc = ? ;";	
	private static final String RETIRER_TACHE_SQL = "update tache set id_utilisateur = ? where code_tc = ? and id_utilisateur = ? ;";
	private static final String UPDATE_TACHE_SQL = "update tache set   design_tc= ?, coutunit_tc = ?, avancement = ?, statut = ?, id_utilisateur = ?, etat = ?, date_fin = ? , code_proj = ? where code_tc = ? ;";
	
	
	public TacheDAO() {
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

	// Méthode pour insérer un nouveau tache dans le système
	
	public void insertTache(Tache tache, int id_utilisateur, String code_proj) throws SQLException {
		
		// déclaration try-with-resource fermera automatiquement la connexion.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TACHE_SQL)) {
			preparedStatement.setString(1, tache.getCode_tc());
			preparedStatement.setString(2, tache.getDesign_tc());
			preparedStatement.setInt(3, tache.getCoutunit_tc());
			preparedStatement.setString(4, code_proj);
			preparedStatement.setInt(5, tache.getAvancement());
			preparedStatement.setString(6, tache.getStatut());
			preparedStatement.setBoolean(7, tache.isEtat());
			preparedStatement.setObject(8, tache.getDate_debut());
			preparedStatement.setObject(9, tache.getDate_fin());
			
			preparedStatement.setInt(10, id_utilisateur);
			
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	
	// Méthode pour annuler un tache, cela implique qu'il n'est plus visible par les roles utilisateurs et admin
	
	public boolean AnnulerTache(String code_tc) throws SQLException {
		boolean rowAnnuler;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(ANNULER_TACHE_SQL)) {
			
			statement.setString(1, "Annuler");
			statement.setInt(2, 0);
			statement.setString(3, code_tc);
			
			rowAnnuler = statement.executeUpdate() > 0;
			
		}
		return rowAnnuler;
	}
	
	// Méthode pour SUSPENDRE un tache
	
	public boolean SuspendreTache(String code_tc) throws SQLException {
		boolean rowSuspendu;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(SUSPENDRE_TACHE_SQL)) {
			
			statement.setString(1, "Suspendu");
			statement.setString(2, code_tc);
			
			rowSuspendu = statement.executeUpdate() > 0;
			
		}
		return rowSuspendu;
	}
	
	// Méthode qui permet de mentioner qu'un tache est terminer
	
	public boolean TerminerTache(String code_tc) throws SQLException {
		boolean rowTerminer;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(TERMINER_TACHE_SQL)) {
			
			statement.setString(1, "Terminer");
			statement.setInt(2, 0);
			statement.setInt(3, 100);
			statement.setString(4, code_tc);
			
			rowTerminer = statement.executeUpdate() > 0;
			
		}
		return rowTerminer;
	}
	
	// Méthode qui permet de mentioner qu'un tache est démarer
	
		public boolean DemarerTache(String code_tc) throws SQLException {
			boolean rowDemarer;
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(DEMARER_TACHE_SQL);) {
				
				statement.setString(1, "En cours");
				statement.setString(2, code_tc);
				
				rowDemarer = statement.executeUpdate() > 0;
				
			}
			return rowDemarer;
		}
	
		// Méthode qui permet d'affecter un tache un role admin
		
		public boolean AffecterTache(String code_tc, int idAdmin) throws SQLException {
			boolean rowAffecter;
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(AFFECTER_TACHE_SQL);) {
				
				statement.setInt(1, idAdmin);
				statement.setString(2, code_tc);
				
				
				rowAffecter = statement.executeUpdate() > 0;
				
			}
			return rowAffecter;
		}
		
		// Méthode qui permet de mentioner qu'un tache est terminer
		
		public boolean RetirerTache(String code_tc, int ancienUser, int nouvelUser) throws SQLException {
			boolean rowRetirer;
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(RETIRER_TACHE_SQL);) {
				
				statement.setInt(1, nouvelUser);
				statement.setString(2, code_tc);
				statement.setInt(3, ancienUser);
				
				rowRetirer = statement.executeUpdate() > 0;
				
			}
			return rowRetirer;
		}
	
	// Méthode pour récupérer les informations d'un utilisateur donner par son id
	
	public Tache selectTache(String code_tc) {
		Tache tache = null;
		// Étape 1: Établissement d'une connexion
		try (Connection connection = getConnection();
				// Étape 2: Créer une déclaration à l'aide d'un objet de connexion
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TACHE_BY_ID);) {
			preparedStatement.setString(1, code_tc);
			System.out.println(preparedStatement);
			// Étape 3: Exécuter la requête ou mettre à jour la requête
			ResultSet rs = preparedStatement.executeQuery();

			// Étape 4: Traitez l'objet ResultSet.
			while (rs.next()) {
				String design_tc = rs.getString("design_tc");
				int coutunit_tc = rs.getInt("coutunit_tc");
				int avancement = rs.getInt("avancement");
				String statut = rs.getString("statut");
				boolean etat = rs.getBoolean("etat");
				Timestamp dateDebut = rs.getTimestamp("date_debut");
				
				Timestamp dateFin = rs.getTimestamp("date_fin");
				
				int idResponsable = rs.getInt("id_utilisateur");
				
				tache = new Tache(idResponsable, code_tc, design_tc, coutunit_tc, avancement, statut, etat, dateDebut, dateFin);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return tache;
	}
	
	// Méthode qui renvoie tous les taches Affecter d'un projet donner
	
		public ArrayList<Tache> selectAlltachesDeProjetAffecter(String codeProj) {

			// utilisation de ressources d’essai pour éviter la fermeture de ressources (code de plaque de chaudière)
			ArrayList<Tache> TachesProjet = new ArrayList<>();
			// Étape 1: Établissement d'une connexion
			try (Connection connection = getConnection();

					// Étape 2: Créer une déclaration à l'aide d'un objet de connexion
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TACHE_BY_PROJECT_AFFECTER);) {
				preparedStatement.setString(1, codeProj);
				
				preparedStatement.setInt(2, 0);
				
				// Étape 3: Exécuter la requête ou mettre à jour la requête
				ResultSet rs = preparedStatement.executeQuery();

				// Étape 4: traiter l'objet ResultSet.
				while (rs.next()) {
					
					String code_tc = rs.getString("code_tc");
					String design_tc = rs.getString("design_tc");
					int coutunit_tc = rs.getInt("coutunit_tc");
					int avancement = rs.getInt("avancement");
					String statut = rs.getString("statut");
					boolean etat = rs.getBoolean("etat");
					Timestamp dateDebut = rs.getTimestamp("date_debut");
					Timestamp dateFin = rs.getTimestamp("date_fin");
					
					int idResponsable = rs.getInt("id_utilisateur");
					
					TachesProjet.add(new Tache(idResponsable, code_tc, design_tc, coutunit_tc, avancement, statut, etat, dateDebut, dateFin));
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			
			
			return TachesProjet;
		}
	
		// Méthode qui renvoie tous les taches d'un projet donner
		
			public ArrayList<Tache> selectAlltachesDeProjetNonAffecter(String codeProj) {

				// utilisation de ressources d’essai pour éviter la fermeture de ressources (code de plaque de chaudière)
				ArrayList<Tache> TachesProjet = new ArrayList<>();
				// Étape 1: Établissement d'une connexion
				try (Connection connection = getConnection();

						// Étape 2: Créer une déclaration à l'aide d'un objet de connexion
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TACHE_BY_PROJECT_NON_AFFECTER);) {
					preparedStatement.setString(1, codeProj);
					
					preparedStatement.setInt(2, 0);
					
					// Étape 3: Exécuter la requête ou mettre à jour la requête
					ResultSet rs = preparedStatement.executeQuery();

					// Étape 4: traiter l'objet ResultSet.
					while (rs.next()) {
						
						String code_tc = rs.getString("code_tc");
						String design_tc = rs.getString("design_tc");
						int coutunit_tc = rs.getInt("coutunit_tc");
						int avancement = rs.getInt("avancement");
						String statut = rs.getString("statut");
						boolean etat = rs.getBoolean("etat");
						Timestamp dateDebut = rs.getTimestamp("date_debut");
						Timestamp dateFin = rs.getTimestamp("date_fin");
						int idResponsable = rs.getInt("id_utilisateur");
						
						
						TachesProjet.add(new Tache(idResponsable,code_tc, design_tc, coutunit_tc, avancement, statut, etat, dateDebut, dateFin));
					}
				} catch (SQLException e) {
					printSQLException(e);
				}
				
				
				return TachesProjet;
			}
			
	
	// Méthode qui renvoie tous les taches qui sont déjà affecter à un role admin
	
	public List<Tache> selectAlltachesAffecter() {

		// utilisation de ressources d’essai pour éviter la fermeture de ressources (code de plaque de chaudière)
		List<Tache> TachesAffecter = new ArrayList<>();
		// Étape 1: Établissement d'une connexion
		try (Connection connection = getConnection();

				// Étape 2: Créer une déclaration à l'aide d'un objet de connexion
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TACHE_AFFECTER);) {
			preparedStatement.setInt(1, 0);
			
			// Étape 3: Exécuter la requête ou mettre à jour la requête
			ResultSet rs = preparedStatement.executeQuery();

			// Étape 4: traiter l'objet ResultSet.
			while (rs.next()) {
				
				String code_tc = rs.getString("code_tc");
				String design_tc = rs.getString("design_tc");
				int coutunit_tc = rs.getInt("coutunit_tc");
				int avancement = rs.getInt("avancement");
				String statut = rs.getString("statut");
				boolean etat = rs.getBoolean("etat");
				Timestamp dateDebut = rs.getTimestamp("date_debut");
				Timestamp dateFin = rs.getTimestamp("date_fin");
				int idResponsable = rs.getInt("id_utilisateur");
				
				
				TachesAffecter.add(new Tache(idResponsable,code_tc, design_tc, coutunit_tc, avancement, statut, etat, dateDebut, dateFin));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		
		
		return TachesAffecter;
	}
	
	// Méthode qui renvoie tous les taches qui ne sont pas encore affecter à un role admin
	
		public List<Tache> selectAllTachesNonAffecter() {

			// utilisation de ressources d’essai pour éviter la fermeture de ressources (code de plaque de chaudière)
			List<Tache> TachesAffecter = new ArrayList<>();
			// Étape 1: Établissement d'une connexion
			try (Connection connection = getConnection();

					// Étape 2: Créer une déclaration à l'aide d'un objet de connexion
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TACHE_NON_AFFECTER);) {
				preparedStatement.setInt(1, 0);
				
				// Étape 3: Exécuter la requête ou mettre à jour la requête
				ResultSet rs = preparedStatement.executeQuery();

				// Étape 4: traiter l'objet ResultSet.
				while (rs.next()) {
					
					String code_tc = rs.getString("code_tc");
					String design_tc = rs.getString("design_tc");
					int coutunit_tc = rs.getInt("coutunit_tc");
					int avancement = rs.getInt("avancement");
					String statut = rs.getString("statut");
					boolean etat = rs.getBoolean("etat");
					Timestamp dateDebut = rs.getTimestamp("date_debut");
					Timestamp dateFin = rs.getTimestamp("date_fin");
					
					int idResponsable = rs.getInt("id_utilisateur");
					
					TachesAffecter.add(new Tache(idResponsable,code_tc, design_tc, coutunit_tc, avancement, statut, etat, dateDebut, dateFin));
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			
			
			return TachesAffecter;
		}
		
		
		// Méthode qui renvoie tous les taches d'un admin qui ne sont pas encore terminer ou annuler
		
			public List<Tache> selectAllTachesOfAdmin(int idUser) {

				// utilisation de ressources d’essai pour éviter la fermeture de ressources (code de plaque de chaudière)
				List<Tache> TachesAffecter = new ArrayList<>();
				// Étape 1: Établissement d'une connexion
				try (Connection connection = getConnection();

						// Étape 2: Créer une déclaration à l'aide d'un objet de connexion
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TACHE_BY_USERS);) {
					
					preparedStatement.setInt(1, idUser);
					preparedStatement.setInt(2, 1);
					
					// Étape 3: Exécuter la requête ou mettre à jour la requête
					ResultSet rs = preparedStatement.executeQuery();

					// Étape 4: traiter l'objet ResultSet.
					while (rs.next()) {
						
						String code_tc = rs.getString("code_tc");
						String design_tc = rs.getString("design_tc");
						int coutunit_tc = rs.getInt("coutunit_tc");
						int avancement = rs.getInt("avancement");
						String statut = rs.getString("statut");
						boolean etat = rs.getBoolean("etat");
						Timestamp dateDebut = rs.getTimestamp("date_debut");
						Timestamp dateFin = rs.getTimestamp("date_fin");
						
						int idResponsable = rs.getInt("id_utilisateur");
						
						TachesAffecter.add(new Tache(idResponsable,code_tc, design_tc, coutunit_tc, avancement, statut, etat, dateDebut, dateFin));
					}
				} catch (SQLException e) {
					printSQLException(e);
				}
				
				
				return TachesAffecter;
			}
			
		
	
	
	// Méthode qui permet à un role super Admin de modifier les informations sur un tache
	
		public boolean updateTacheInfos(String code_tache, String lib_tc,  int prixU, int avancement, String statut, boolean etat, Timestamp endDate, int codeResponsable, String codeProjet) throws SQLException {
			
			boolean rowUpdated;
			
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(UPDATE_TACHE_SQL);) {
				
				
				statement.setString(1, lib_tc);
				
				statement.setInt(2, prixU);
				
				statement.setInt(3, avancement);
				
				statement.setString(4, statut);
				
				statement.setInt(5, codeResponsable);
				statement.setBoolean(6, etat);
				statement.setTimestamp(7, endDate);
				statement.setString(8, codeProjet);
				statement.setString(9, code_tache);
				
				
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
