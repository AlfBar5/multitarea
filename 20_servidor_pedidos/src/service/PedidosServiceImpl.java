package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mysql.cj.Query;

import helpers.EntityManagerLocator;
import model.Pedido;
import static helpers.EntityManagerLocator.*;

public class PedidosServiceImpl implements PedidosService {

	
	//pedidos por tienda
	@Override
	public List<Pedido> pedidosTienda(String tienda) {

		
		EntityManager em=EntityManagerLocator.getEntityManager();
		String jpql="select p from Pedido p where p.tienda=?1";
		return em.createQuery(jpql,Pedido.class).setParameter(1, tienda).getResultList();
		
		
		
	}

	
	//todos los pedidos
	@Override
	public List<Pedido> pedidosTienda() {

		EntityManager em = EntityManagerLocator.getEntityManager();
		
		String jpql ="select p from pedidos p";
								
		return em.createQuery(jpql,Pedido.class).getResultList();
		
	}

	
	
	
	
	
	
	
}

