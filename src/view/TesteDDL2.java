package view;

import model.Atendente;
import model.Atendimento;
import model.Cliente;
import model.Entregador;
import org.hibernate.SessionFactory;
import persistence.AtendenteDao;
import persistence.AtendimentoDao;
import persistence.ClienteDao;
import persistence.EntregadorDao;
import util.HibernateUtil;

import java.time.LocalDate;

public class TesteDDL2 {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		// ===================================================
		Cliente c1 = new Cliente();
		c1.setCpf("33322255569");
		c1.setNome("Oslivaldo Vieira");
		c1.setPronomeTratamento("Sr.");
		c1.setTelefone("11955884422");
		c1.setEmail("ollivaldo@vieira.com");

		ClienteDao cDao = new ClienteDao(sf);
		cDao.insere(c1);
//
//		List<Cliente> lista = cDao.lista();
//		lista.forEach(cliente -> System.out.println(cliente));

		// ===================================================
		Atendente at1 = new Atendente();
		at1.setNome("Varilda Santos");
		at1.setNascimento(LocalDate.ofEpochDay(1987-10-11));
		at1.setSalario(3000.00f);
		at1.setTelefone("1188887755");
		at1.setEmailAtendente("varilda@empresa.com");
		at1.setHorarioEntrada(9);
		at1.setHorarioSaida(17);

		AtendenteDao atDao = new AtendenteDao(sf);
		atDao.insere(at1);

		// ===================================================
		Atendente at2 = new Atendente();
		at2.setNome("Zumira Costa");
		at2.setNascimento(LocalDate.ofEpochDay(1975-8-5));
		at2.setSalario(4000.00f);
		at2.setTelefone("1155441122");
		at2.setEmailAtendente("zumira@empresa.com");
		at2.setHorarioEntrada(9);
		at2.setHorarioSaida(17);

		atDao.insere(at2);

		// ===================================================
		Entregador en1 = new Entregador();
		en1.setNome("Claudio Bonaro");
		en1.setNascimento(LocalDate.ofEpochDay(1991-12-15));
		en1.setSalario(2500.00f);
		en1.setTelefone("1123119874");
		en1.setNumeroCNH("545465658111");
		en1.setCategoriaCNH("A");

		EntregadorDao enDao = new EntregadorDao(sf);
		enDao.insere(en1);

		// ===================================================
		Atendimento atdm = new Atendimento();
		atdm.setAtendente(at1);
		atdm.setCliente(c1);
		atdm.setDataAtendimento(java.time.LocalDateTime.now());

		AtendimentoDao atdmDao = new AtendimentoDao(sf);
		atdmDao.insere(atdm);

	}
}
