package entity;

import java.util.Date;

public class Task {
    private Integer id;
    private Integer belongs;
    private String titel;
    private String content;
    private Date receptionDate;
    private Date endingDate;
    private Date doneDate;
    private Boolean done;
    private Boolean verified;

    public Task(String text, String fieldTitleText, String fieldContentText, Date receptionDate, Date endingDate, boolean done, boolean verified) {
        this.id = new Integer(-1);
        this.belongs = new Integer(-1);
        this.titel = new String();
        this.content = new String();
        this.receptionDate = new Date();
        this.endingDate = new Date();
        this.doneDate = new Date();
        this.done = new Boolean(false);
        this.verified = new Boolean(false);
    }

    public Task(Integer id, Integer belongs, String titel, String content, Date receptionDate, Date endingDate, Date doneDate, Boolean done, Boolean verified) {
        this.id = id;
        this.belongs = belongs;
        this.titel = titel;
        this.content = content;
        this.receptionDate = receptionDate;
        this.endingDate = endingDate;
        this.doneDate = doneDate;
        this.done = done;
        this.verified = verified;
    }

    public Task(Integer belongs, String titel, String content, Date receptionDate, Date endingDate, Boolean done, Boolean verified) {
        this.id = new Integer(-1);
        this.belongs = belongs;
        this.titel = titel;
        this.content = content;
        this.receptionDate = receptionDate;
        this.endingDate = endingDate;
        this.doneDate = null;
        this.done = done;
        this.verified = verified;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBelongs() {
        return belongs;
    }

    public void setBelongs(Integer belongs) {
        this.belongs = belongs;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReceptionDate() {
        return receptionDate;
    }

    public void setReceptionDate(Date receptionDate) {
        this.receptionDate = receptionDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public Date getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(Date doneDate) {
        this.doneDate = doneDate;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (id != null ? !id.equals(task.id) : task.id != null) return false;
        if (belongs != null ? !belongs.equals(task.belongs) : task.belongs != null) return false;
        if (titel != null ? !titel.equals(task.titel) : task.titel != null) return false;
        if (content != null ? !content.equals(task.content) : task.content != null) return false;
        if (receptionDate != null ? !receptionDate.equals(task.receptionDate) : task.receptionDate != null)
            return false;
        if (endingDate != null ? !endingDate.equals(task.endingDate) : task.endingDate != null) return false;
        if (doneDate != null ? !doneDate.equals(task.doneDate) : task.doneDate != null) return false;
        if (done != null ? !done.equals(task.done) : task.done != null) return false;
        return verified != null ? verified.equals(task.verified) : task.verified == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (belongs != null ? belongs.hashCode() : 0);
        result = 31 * result + (titel != null ? titel.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (receptionDate != null ? receptionDate.hashCode() : 0);
        result = 31 * result + (endingDate != null ? endingDate.hashCode() : 0);
        result = 31 * result + (doneDate != null ? doneDate.hashCode() : 0);
        result = 31 * result + (done != null ? done.hashCode() : 0);
        result = 31 * result + (verified != null ? verified.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", belongs=" + belongs +
                ", titel='" + titel + '\'' +
                ", content='" + content + '\'' +
                ", receptionDate=" + receptionDate +
                ", endingDate=" + endingDate +
                ", doneDate=" + doneDate +
                ", done=" + done +
                ", verified=" + verified +
                '}';
    }
}
