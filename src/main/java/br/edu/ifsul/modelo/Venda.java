package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author camila
 */
@Entity
@Table(name = "venda")
public class Venda implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_venda", sequenceName = "seq_venda_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_venda", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O valor total deve ser informado!")
    @Column(name = "valortotal", nullable = false, columnDefinition = "Numeric(10,2)")
    private Double valorTotal;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data da venda deve ser informada!")
    @Column(name = "data", nullable = false)
    private Calendar data;
    
    @NotNull(message = "Os itens da venda devem ser informados!") // restrição para rejeitar campo nulo
    @OneToMany(mappedBy = "venda") // variável venda (Venda) em ItemVenda
    private List<ItemVenda> itens; // agregação por composição
    
    @NotNull(message = "O cliente deve ser informado!") // restrição para rejeitar campo nulo
    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "id", nullable = false)
    private Cliente cliente;

    public Venda() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Venda other = (Venda) obj;
        return Objects.equals(this.id, other.id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
