import java.sql.*;

public class sal {

	public static void main(String[] args) {
		abrirConexion();

	}
		
	public static void abrirConexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String DB= "amunikearkanoid";
			String user="amunike";
			String pass="amunikeadsi";
			String url="jdbc:mysql://db4free.net:3306/"+DB+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
			
			Connection conn=DriverManager.getConnection(url,user,pass);
			
				/*JSONArray ranking= new JSONArray();
				ranking.put("usuario");
				ranking.put("dificultad");
				ranking.put("puntos");
				*/
				
				if(conn!=null) {
					Statement st=conn.createStatement();
					
					ResultSet rs= st.executeQuery("Select * from R3");
					
					while(rs.next()) {
						System.out.println(rs.getString("Usuario") +" " + rs.getInt("dificultad")+ " " + rs.getInt("puntos"));
					}
					
				}else {
					System.out.println("Fallo");
				}
				
			} catch(ClassNotFoundException e1) {
				System.out.println("ERROR 1 "+e1.getMessage());
			} catch(SQLException se) {
				System.out.println("ERROR 2 "+se.getMessage());
			} catch(Exception e) {
				System.out.println("ERROR 3 "+e.getMessage());
			} 
			
		}
		
	}
