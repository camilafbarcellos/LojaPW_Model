package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author camila
 */
@Entity
@Table(name = "fornecedor")
public class Fornecedor implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_fornecedor", sequenceName = "seq_fornecedor_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_fornecedor", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O nome deve ser informado!") // restrição para rejeitar campo em branco
    @Length(max = 40, message = "O nome não pode ter mais que {max} caracteres!") // restrição para tamanho
    @Column(name = "nome", nullable = false, length = 40)
    private String nome;
    
    @NotBlank(message = "O CNPJ deve ser informado!") // restrição para rejeitar campo em branco
    @Length(max = 14, min = 14, message = "O CNPJ deve ter {max} caracteres!") // restrição para tamanho
    @Column(name = "cnpj", nullable = false, length = 14)
    private String cnpj;
    
    @NotBlank(message = "O nome do vendedor responsável deve ser informado!") // restrição para rejeitar campo em branco
    @Length(max = 40, message = "O nome do vendedor não pode ter mais que {max} caracteres!") // restrição para tamanho
    @Column(name = "vendedor", nullable = false, length = 40)
    private String vendedor;
    
    @NotBlank(message = "O email deve ser informado!") // restrição para rejeitar campo em branco
    @Length(max = 40, message = "O email não pode ter mais que {max} caracteres!") // restrição para tamanho
    @Column(name = "email", nullable = false, length = 40)
    private String email;
    
    @NotBlank(message = "O setor deve ser informado!") // restrição para rejeitar campo em branco
    @Length(max = 35, message = "O setor não pode ter mais que {max} caracteres!") // restrição para tamanho
    @Column(name = "setor", nullable = false, length = 35)
    private String setor;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
    
    public Fornecedor() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final Fornecedor other = (Fornecedor) obj;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }
}
