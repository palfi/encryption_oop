import java.util.ArrayList;
import java.util.List;

public class Repo {
    private final List<KontaktInfo> kontaktInfoList = new ArrayList<>();

    public KontaktInfo get(int id) {
        return kontaktInfoList.stream().filter(kontaktInfo1 -> kontaktInfo1.getId() == id).findFirst().get();
    }

    public void insert(KontaktInfo kontaktInfo) {
        kontaktInfoList.add(kontaktInfo);
    }
}
