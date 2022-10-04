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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author camila
 */
@Entity
@Table(name = "produto")
public class Produto implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_produto", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O nome deve ser informado!") // restrição para rejeitar campo em branco
    @Length(max = 100, message = "O nome não pode ter mais que {100} caracteres!") // restrição para tamanho
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    
    @NotNull(message = "O valor deve ser informado!")
    @Column(name = "valor", nullable = false, columnDefinition = "Numeric(10,2)")
    private Double valor;
    
    @NotNull(message = "O estoque deve ser informado!")
    @Column(name = "estoque", nullable = false, columnDefinition = "Integer")
    private Integer estoque;
    
    @NotNull(message = "O fornecedor deve ser informado!") // restrição para rejeitar campo nulo
    @ManyToOne
    @JoinColumn(name = "fornecedor", referencedColumnName = "id", nullable = false)
    private Fornecedor fornecedor;

    public Produto() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Produto other = (Produto) obj;
        return Objects.equals(this.id, other.id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
