package test.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "CHANGE", schema = "store")
public class Change {
    @Id
    @Column(name = "CHANGE_ID", nullable = false)
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(name = "NAME_TABLE_OF_CHANGED", length = 200)
    private String nameTableOfChanged;

    @Column(name = "RECORD_CHANGED_ID", nullable = false)
    private Integer recordChangedId;

    @Column(name = "ACTION_WITH_TABLE", length = 200)
    private String actionWithTable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameTableOfChanged() {
        return nameTableOfChanged;
    }

    public void setNameTableOfChanged(String nameTableOfChanged) {
        this.nameTableOfChanged = nameTableOfChanged;
    }

    public Integer getRecordChangedId() {
        return recordChangedId;
    }

    public void setRecordChangedId(Integer recordChangedId) {
        this.recordChangedId = recordChangedId;
    }

    public String getActionWithTable() {
        return actionWithTable;
    }

    public void setActionWithTable(String actionWithTable) {
        this.actionWithTable = actionWithTable;
    }
}
