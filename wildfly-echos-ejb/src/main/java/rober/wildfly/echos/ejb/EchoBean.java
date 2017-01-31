package rober.wildfly.echos.ejb;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import rober.wildfly.echos.common.IEcho;
import rober.wildfly.echos.jpa.Echo;

@Stateless
public class EchoBean implements IEcho {

	private String getMost() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd H:mm:ss:S");
		return sdf.format(date);
	}

	@PersistenceContext(unitName = "WildflyEchos")
	private EntityManager oEntityManager;

	@Override
	public int storeEcho(String message) {
		int n = ((Number)oEntityManager.createNamedQuery("Echo.countAll").getSingleResult()).intValue();
		Echo oEcho = new Echo(new Integer(n+1), message + " - " + getMost());
		oEntityManager.persist(oEcho);
		return 0;
	}

	@Override
	public Echo getEchoById(int p_id) {
		return oEntityManager.find(Echo.class, p_id);
	}

	@Override
	public List<Echo> getAllEchos() {
		CriteriaBuilder cb = oEntityManager.getCriteriaBuilder();
		CriteriaQuery<Echo> criteria = cb.createQuery(Echo.class);
		Root<Echo> member = criteria.from(Echo.class);
		criteria.select(member).orderBy(cb.asc(member.get("message")));
		return oEntityManager.createQuery(criteria).getResultList();
	}

	@Override
	public int updateEcho(int id,String updateName) {
		
		Echo echo = getEchoById(id);
		echo.setMessage(updateName);
		oEntityManager.merge(echo);
		
		return 0;
		
	}
	@Override
	public int updateEcho(){
		return 0;
	}
	
	

	
	

	

}
