package xstream;

import com.thoughtworks.xstream.annotations.*;

import java.util.ArrayList;
import java.util.List;

@XStreamAlias("student")
class Student {
  
  @XStreamAlias("name")
  @XStreamAsAttribute
  private String studentName;
  
  @XStreamImplicit
  private List<Note> notes = new ArrayList<Note>();
  
  public Student(String name) {
    this.studentName = name;
  }
  
  public void addNote(Note note) {
    notes.add(note);
  }
  
  public String getName() {
    return studentName;
  }
  
  public List<Note> getNotes() {
    return notes;
  }
  
  @XStreamOmitField
  private int type;
  
  public int getType() {
    return type;
  }
  
  public void setType(int type) {
    this.type = type;
  }
}

