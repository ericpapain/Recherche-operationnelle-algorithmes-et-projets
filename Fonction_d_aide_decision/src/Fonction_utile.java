public class Fonction_utile {
	
	public static void switchCaseMethode(int val){
		switch(val){
		case 9:
			System.out.println("ta un 9 mon amis la note est médiocre");
			break;
		
		case 12:
			System.out.println("un 12 c'est pas mal le vieux");
		
		default:
			System.out.println("vous avez entrer un "+val);
		}		
	}
	
	public static void main(String[] args){
		switchCaseMethode(13);
	}
}
