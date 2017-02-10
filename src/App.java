public class App {

    public static void main(String[] args) {
        Service service = new Service(new Repo());
        service.insert(new KontaktInfoImpl(1, new JaNeiImpl("J"), "Name"));
        service.insert(new KontaktInfoImpl(2, new JaNeiImpl("J"), "Name2"));
        String bruker = "bruker";
        KontaktInfo kontaktInfo = service.get(1, bruker);
        print(kontaktInfo);

        kontaktInfo = service.get(2, bruker);
        print(kontaktInfo);

        kontaktInfo = service.get(1, "bruker2");
        print(kontaktInfo);

        kontaktInfo = service.get(2, "bruker2");
        print(kontaktInfo);
    }

    private static void print(KontaktInfo kontaktInfo) {
        System.out.println("------------------------");
        System.out.println(kontaktInfo.getIsEmail().toStringRep());
        System.out.println(kontaktInfo.getName());
    }
}

