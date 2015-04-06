package com.dongzi.model;

import javax.persistence.*;

/**
 * Tuser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tboard", catalog = "sy")
public class Tboard implements java.io.Serializable {

    // Fields
    private String id;
    private String name;
    private String fsan;
    private String mac;
    private String sn;
    private String owner;
    private String note;

    // Constructors

    /** default constructor */
    public Tboard() {
    }


    /** full constructor */
    public Tboard(String id, String name, String fsan, String mac, String sn, String owner, String note) {
        this.id = id;
        this.name = name;
        this.fsan = fsan;
        this.mac = mac;
        this.sn = sn;
        this.owner = owner;
        this.note = note;
    }

    // Property accessors
    @Id
    @Column(name = "ID", unique = true, nullable = false, length = 36)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "fsan", nullable = false, length = 32)
    public String getFsan() {
        return this.fsan;
    }

    public void setFsan(String fsan) {
        this.fsan = fsan;
    }

    @Column(name = "mac", nullable = false, length = 32)
    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    @Column(name = "sn", nullable = false, length = 32)
    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    @Column(name = "owner", nullable = false, length = 32)
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Column(name = "note", nullable = false, length = 32)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tuser")
//	public Set<Tusertrole> getTusertroles() {
//		return this.tusertroles;
//	}
//
//	public void setTusertroles(Set<Tusertrole> tusertroles) {
//		this.tusertroles = tusertroles;
//	}

}