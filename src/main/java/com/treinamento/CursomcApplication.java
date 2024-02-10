package com.treinamento;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.treinamento.domain.Categoria;
import com.treinamento.domain.Cidade;
import com.treinamento.domain.Cliente;
import com.treinamento.domain.Endereco;
import com.treinamento.domain.Estado;
import com.treinamento.domain.Produto;
import com.treinamento.domain.enums.TipoCliente;
import com.treinamento.repositories.CategoriaRepository;
import com.treinamento.repositories.CidadeRepository;
import com.treinamento.repositories.ClienteRepository;
import com.treinamento.repositories.EnderecoRepository;
import com.treinamento.repositories.EstadoRepository;
import com.treinamento.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	EstadoRepository estadoRepository;
	@Autowired
	CidadeRepository cidadeRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria("Informatica");
		Categoria cat2 = new Categoria("Escritório");
		
		Produto p1 = new Produto("Computador",2000.00);
		Produto p2 = new Produto("Impressora",800.00);
		Produto p3 = new Produto("Mause",80.00);
		
		cat1.getProtutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProtutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat1));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado estado = new Estado("Minas Gerais");
		Estado estado2 = new Estado("São Paulo");
		
		Cidade cidade = new Cidade("Uberlândia",estado);
		Cidade cidade2 = new Cidade("São Paulo",estado2);
		Cidade cidade3 = new Cidade("Campinas",estado2);
		
		estado.getCidades().addAll(Arrays.asList(cidade));
		estado.getCidades().addAll(Arrays.asList(cidade2,cidade3));
		
		estadoRepository.saveAll(Arrays.asList(estado,estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade,cidade2,cidade3));
		
		Cliente cli = new Cliente("Maria silva","maria@teset.com.br",TipoCliente.PESSOAFISICA);
		cli.getTelefones().addAll(Arrays.asList("(85)855222245","(54)654879875"));
		
		Endereco e1 = new Endereco("Rua Flores","380","Jardim","654132132","13254654",cli,cidade);
		Endereco e2 = new Endereco("Avenida Matos","105","Sala 800","Centro","13254654",cli,cidade2);
		
		cli.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
	}

}
