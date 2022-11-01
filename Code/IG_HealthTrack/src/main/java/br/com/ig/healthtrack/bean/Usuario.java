package br.com.ig.healthtrack.bean;

import java.sql.Blob;
import java.util.Calendar;

import br.com.ig.healthtrack.utils.CriptografiaUtils;

public class Usuario {
	private int codigo;	
	private String nome;
	private String apelido;
	private Blob foto;
	private int altura;
	private String cpf;
	private Calendar dataCadastro;
	private Calendar dataNascimento;
	private String email;
	private String senha;
	private String celular;
	private int sexo;
	
	public Usuario(int codigo, String nome, String apelido, Blob foto, int altura, String cpf, Calendar dataCadastro,
			Calendar dataNascimento, String email, String senha, String celular, int sexo) {
		super();
		this.nome = nome;
		this.apelido = apelido;
		this.foto = foto;
		this.altura = altura;
		this.cpf = cpf;
		this.dataCadastro = dataCadastro;
		this.dataNascimento = dataNascimento;
		this.email = email;
		setSenha(senha);
		//		this.senha = senha;
		this.celular = celular;
		this.codigo = codigo;
		this.sexo = sexo;
	}
	

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public Blob getFoto() {
		return foto;
	}
	public void setFoto(Blob foto) {
		this.foto = foto;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Calendar getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		try {
			this.senha = CriptografiaUtils.criptografar(senha);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	public void setSenhaCriptografada(String senha) {
		this.senha = senha;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public int getSexo() {
		return sexo;
	}


	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

}
