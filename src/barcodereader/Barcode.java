/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package barcodereader;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SibusisoJ
 */
@Entity
@Table(name = "barcode")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Barcode.findAll", query = "SELECT b FROM Barcode b"),
    @NamedQuery(name = "Barcode.findById", query = "SELECT b FROM Barcode b WHERE b.id = :id"),
    @NamedQuery(name = "Barcode.findByBarcodeReader", query = "SELECT b FROM Barcode b WHERE b.barcodeReader = :barcodeReader"),
    @NamedQuery(name = "Barcode.findByDate", query = "SELECT b FROM Barcode b WHERE b.date = :date")})
public class Barcode implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "BarcodeReader")
    private String barcodeReader;
    @Basic(optional = false)
    @Column(name = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Barcode() {
    }

    public Barcode(Integer id) {
        this.id = id;
    }

    public Barcode(Integer id, String barcodeReader, Date date) {
        this.id = id;
        this.barcodeReader = barcodeReader;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBarcodeReader() {
        return barcodeReader;
    }

    public void setBarcodeReader(String barcodeReader) {
        this.barcodeReader = barcodeReader;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barcode)) {
            return false;
        }
        Barcode other = (Barcode) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "barcodereader.Barcode[ id=" + id + " ]";
    }
    
}
