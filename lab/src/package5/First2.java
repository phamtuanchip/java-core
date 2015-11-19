package package5;

public class First2 {
 public static void main(String[] args) {
	
	 try {
		Input.insertId();
	} catch (IDLengthIncorectExeption e1) {
		e1.printStackTrace();
	} catch (IDIncorectExeption e2) {
		e2.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		System.out.println("Always go to there");
	}
	 
	 try {
		Input.insertUserName();
	} catch (DataInputExeption e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		System.out.println("Always go to there");
	}
 }
}
