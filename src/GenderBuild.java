public class GenderBuild
{
    public static Gender create(String gender) throws Exception {
        if (gender.equals("M")) return Gender.M;
        if (gender.equals("F")) return Gender.F;

        throw new Exception("Invalid selected gender.");
    }
}