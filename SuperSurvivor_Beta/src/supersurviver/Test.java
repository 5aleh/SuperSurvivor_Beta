package supersurviver;


import supersurviver.DatabaseBean;

public class Test {
    public static void main(String args[]){
        DatabaseBean t = new DatabaseBean();

        String asd = DatabaseBean.RetrieveImages(1).getIpath();
        System.out.println(asd);
        
        String user = DatabaseBean.RetrieveUser(2).getUname();
        String pass = DatabaseBean.RetrieveUser(2).getPass();
        System.out.println(user);
        System.out.println(pass);

//        User testuser = new User(628,"zac628","garbage");
//        DatabaseBean.WriteUser(testuser);
    }

}
