package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import helpers.EntityManagerLocator;
import model.Pedido;

public class PedidosDaoImpl implements PedidosDao {

	@Override
	public void guardarPedido(Pedido pedido) {
		EntityManager em=EntityManagerLocator.getEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(pedido);
		tx.commit();
	}

}
