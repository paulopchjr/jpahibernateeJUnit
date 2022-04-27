package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity

/*Consulta Nomeadas - aula 25.19*/
@NamedQueries({
	
	@NamedQuery(name="UsuarioPessoa.todos", query = "select u from UsuarioPessoa u "),
	@NamedQuery(name="UsuarioPessoa.buscaPorNome", query="select u from UsuarioPessoa u where u.nome = :nome")
})
public class UsuarioPessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // gera um novo id para um novo registro automatico
	private Long id;

	private String nome;
	private String sobreNome;
	private String email;
	private String login;
	private String senha;
	
	/*um para muitos, mapea o atributo responsável por identificar os telefones na classe TelefoneUser.  */
	@OneToMany(mappedBy = "usuarioPessoa", fetch =FetchType.EAGER) // traz os telefones das pessoas;
	private List<TelefoneUser>telefoneUsers;
	
	public void setTelefoneUsers(List<TelefoneUser> telefoneUsers) {
		this.telefoneUsers = telefoneUsers;
	}
	public List<TelefoneUser> getTelefoneUsers() {
		return telefoneUsers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "UsuarioPessoa [id=" + id + ", nome=" + nome + ", sobreNome=" + sobreNome + ", email=" + email
				+ ", login=" + login + ", senha=" + senha + "]";
	}

	
	
}
