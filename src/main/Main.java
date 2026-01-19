public class Main {
    public static void main(String[] args) {

        Player mage1 = new Mage("Merlin");
        Player mage2 = new Mage("Vivi");

        mage1.attack(mage2);
        mage1.attack(mage2);
    }
}