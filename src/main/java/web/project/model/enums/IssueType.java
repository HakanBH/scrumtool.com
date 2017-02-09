package web.project.model.enums;

public enum IssueType {
    ISSUE(0),
    BUG(1),
    EPIC(2),
    STORY(3),
    REVIEW(4),
    TEST(5),
    TASK(6);

    private final int value;

    private IssueType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    }
