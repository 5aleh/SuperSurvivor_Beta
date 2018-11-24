public class Test {
    public static void main(String args[]){
        DatabaseBean t = new DatabaseBean();

        String asd = DatabaseBean.RetrieveImages(1).getIpath();
        System.out.print(asd);

        User testuser = new User(628,"zac628","garbage");
        DatabaseBean.WriteUser(testuser);
    }

}
