package W9_Exercises;

public class MainClass_1 {
    public static void main(String[] args) {
//      User user = new User();
//      System.out.println(user.toString());
        User user = User.getUserInfo();
//      user.getAddress();
//      user.readInfo();
//      user.getUserBirthYear();

        String book = user.getFavoriteBook();
        user.favoriteColour();



    }
}
