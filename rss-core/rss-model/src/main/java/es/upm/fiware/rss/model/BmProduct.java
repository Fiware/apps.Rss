/**
 * Revenue Settlement and Sharing System GE
 * Copyright (C) 2011-2014,  Javier Lucio - lucio@tid.es
 * Telefonica Investigacion y Desarrollo, S.A.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package es.upm.fiware.rss.model;

// Generated 24-abr-2012 17:09:13 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * BmProduct generated by hbm2java.
 */
@Entity
@Table(name = "bm_product",
    uniqueConstraints = @UniqueConstraint(
        columnNames = {
            "NU_SERVICE_ID", "TX_NAME"
        }))
public class BmProduct implements java.io.Serializable {

    private long nuProductId;
    private BmService bmService;
    private BmServiceProductType bmServiceProductType;
    private String txName;
    private String txProductDescription;
    private String tcIsServiceProductYn;
    private Set<BmProductVsOb> bmProductVsObs = new HashSet<BmProductVsOb>(0);

    /**
     * Constructor.
     */
    public BmProduct() {
    }

    /**
     * Constructor.
     * 
     * @param nuProductId
     * @param bmService
     * @param bmServiceProductType
     * @param txName
     * @param tcIsServiceProductYn
     */
    public BmProduct(long nuProductId, BmService bmService, BmServiceProductType bmServiceProductType, String txName,
        String tcIsServiceProductYn) {
        this.nuProductId = nuProductId;
        this.bmService = bmService;
        this.bmServiceProductType = bmServiceProductType;
        this.txName = txName;
        this.tcIsServiceProductYn = tcIsServiceProductYn;
    }

    /**
     * Constructor.
     * 
     * @param nuProductId
     * @param bmService
     * @param bmServiceProductType
     * @param txName
     * @param txProductDescription
     * @param tcIsServiceProductYn
     * @param bmProductVsObs
     * @param bmTaxLandVsTaxProducts
     * @param bmProductCategories
     */
    public BmProduct(long nuProductId, BmService bmService, BmServiceProductType bmServiceProductType, String txName,
        String txProductDescription, String tcIsServiceProductYn, Set<BmProductVsOb> bmProductVsObs) {
        this.nuProductId = nuProductId;
        this.bmService = bmService;
        this.bmServiceProductType = bmServiceProductType;
        this.txName = txName;
        this.txProductDescription = txProductDescription;
        this.tcIsServiceProductYn = tcIsServiceProductYn;
        this.bmProductVsObs = bmProductVsObs;
    }

    @Id
    @Column(name = "NU_PRODUCT_ID", unique = true, nullable = false, precision = 10, scale = 0)
    public long getNuProductId() {
        return this.nuProductId;
    }

    public void setNuProductId(long nuProductId) {
        this.nuProductId = nuProductId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "NU_SERVICE_ID", nullable = false)
    public BmService getBmService() {
        return this.bmService;
    }

    public void setBmService(BmService bmService) {
        this.bmService = bmService;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "NU_SERVICE_ID", referencedColumnName = "NU_SERVICE_ID", nullable = true,
            insertable = false, updatable = false),
        @JoinColumn(name = "NU_SERVICE_PRODUCT_TYPE_ID", referencedColumnName = "NU_SERVICE_PRODUCT_TYPE_ID",
            insertable = false, updatable = false)
    })
    public BmServiceProductType getBmServiceProductType() {
        return this.bmServiceProductType;
    }

    public void setBmServiceProductType(BmServiceProductType bmServiceProductType) {
        this.bmServiceProductType = bmServiceProductType;
    }

    @Column(name = "TX_NAME", nullable = false, length = 40)
    public String getTxName() {
        return this.txName;
    }

    public void setTxName(String txName) {
        this.txName = txName;
    }

    @Column(name = "TX_PRODUCT_DESCRIPTION", length = 250)
    public String getTxProductDescription() {
        return this.txProductDescription;
    }

    public void setTxProductDescription(String txProductDescription) {
        this.txProductDescription = txProductDescription;
    }

    @Column(name = "TC_IS_SERVICE_PRODUCT_YN", nullable = false, length = 1)
    public String getTcIsServiceProductYn() {
        return this.tcIsServiceProductYn;
    }

    public void setTcIsServiceProductYn(String tcIsServiceProductYn) {
        this.tcIsServiceProductYn = tcIsServiceProductYn;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bmProduct")
    public Set<BmProductVsOb> getBmProductVsObs() {
        return this.bmProductVsObs;
    }

    public void setBmProductVsObs(Set<BmProductVsOb> bmProductVsObs) {
        this.bmProductVsObs = bmProductVsObs;
    }

}
