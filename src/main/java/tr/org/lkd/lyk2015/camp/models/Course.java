package tr.org.lkd.lyk2015.camp.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Course extends AbstractBaseModel {

	private String name;

	private String description;

	private String prerequisites;

	private String detailsPageLink;

	private Boolean active = true;

	@ManyToMany(mappedBy = "courses")
	private Set<Instructor> instructors = new HashSet<>();

	public Boolean isActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrerequisites() {
		return this.prerequisites;
	}

	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}

	public String getDetailsPageLink() {
		return this.detailsPageLink;
	}

	public void setDetailsPageLink(String detailsPageLink) {
		this.detailsPageLink = detailsPageLink;
	}

	public Set<Instructor> getInstructors() {
		return this.instructors;
	}

	public void setInstructors(Set<Instructor> instructors) {
		this.instructors = instructors;
	}

}
