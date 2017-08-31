package web.project.model.enums;

public enum MemberRole {
    OWNER(0),
    SCRUM_MASTER(1),
    DEVELOPER(2),
    DEV_OPS(3),
    TESTER(4);

    private final int value;

    private MemberRole(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
