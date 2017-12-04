public class CompanySystem {
    public static void main(String args[])
    {
        CompanyFactory factory = new CompanyFactory();
        Company com = factory.createRandomCompany(4);
        System.out.println(com);

    }
}