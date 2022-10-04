package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author camila
 */
@Entity
@Table(name = "itemvenda")
public class ItemVenda implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_itemvenda", sequenceName = "seq_itemvenda_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_itemvenda", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "A quantidade deve ser informada!")
    @Column(name = "quantidade", nullable = false, columnDefinition = "Integer")
    private Integer quantidade;
    
    @NotNull(message = "A venda deve ser informada!") // restrição para rejeitar campo nulo
    @ManyToOne
    @JoinColumn(name = "venda", referencedColumnName = "id", nullable = false)
    private Venda venda; // ref. a entidade forte da composição (Venda)

    public ItemVenda() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemVenda other = (ItemVenda) obj;
        return Objects.equals(this.id, other.id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
}
