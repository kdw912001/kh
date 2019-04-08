package pet.model.vo;

import java.io.Serializable;

public class Pet implements Serializable {
	private static final long serialVersionUID = 1313275459825387673L;
	
	private int petNo;
	private String petName;
	private String petBreads;
	private String petDate;
	private String petSize;
	private String petGender;
	private String petNeutralize;
	private String petCharater;
	private String userId;
	
	public Pet () {}

	public Pet(int petNo, String petName, String petBreads, String petDate, String petSize, String petGender,
			String petNeutralize, String petCharater, String userId) {
		super();
		this.petNo = petNo;
		this.petName = petName;
		this.petBreads = petBreads;
		this.petDate = petDate;
		this.petSize = petSize;
		this.petGender = petGender;
		this.petNeutralize = petNeutralize;
		this.petCharater = petCharater;
		this.userId = userId;
	}

	public int getPetNo() {
		return petNo;
	}

	public void setPetNo(int petNo) {
		this.petNo = petNo;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getPetBreads() {
		return petBreads;
	}

	public void setPetBreads(String petBreads) {
		this.petBreads = petBreads;
	}

	public String getPetDate() {
		return petDate;
	}

	public void setPetDate(String petDate) {
		this.petDate = petDate;
	}

	public String getPetSize() {
		return petSize;
	}

	public void setPetSize(String petSize) {
		this.petSize = petSize;
	}

	public String getPetGender() {
		return petGender;
	}

	public void setPetGender(String petGender) {
		this.petGender = petGender;
	}

	public String getPetNeutralize() {
		return petNeutralize;
	}

	public void setPetNeutralize(String petNeutralize) {
		this.petNeutralize = petNeutralize;
	}

	public String getPetCharater() {
		return petCharater;
	}

	public void setPetCharater(String petCharater) {
		this.petCharater = petCharater;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString () {
		return
				this.petNo + ", " + this.petName + ", " + this.petBreads + ", " + this.petDate + ", " + this.petSize + ", "
			  + this.petGender + ", " + this.petNeutralize + ", " + this.petCharater + ", " + this.userId;
	}

}
