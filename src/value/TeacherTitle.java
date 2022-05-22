package value;

public enum TeacherTitle {
    GS("GS-TS"),
    PGS("PGS-TS"),
    GV("Giảng viên chính"),
    TS("Thạc sỹ");

    public String value;
    TeacherTitle(String value){
        this.value = value;
    }
}
