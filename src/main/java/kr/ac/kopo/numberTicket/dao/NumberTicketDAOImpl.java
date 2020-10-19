package kr.ac.kopo.numberTicket.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.member.vo.MemberVO;
import kr.ac.kopo.member.vo.TellerVO;
import kr.ac.kopo.numberTicket.vo.AdminTicketVO;
import kr.ac.kopo.numberTicket.vo.AnalysisVO;
import kr.ac.kopo.numberTicket.vo.BasketVO;
import kr.ac.kopo.numberTicket.vo.NumberTicket_LatLngVO;
import kr.ac.kopo.numberTicket.vo.NumberTicket_NumberTicketVO;
import kr.ac.kopo.numberTicket.vo.PreSubmitVO;
import kr.ac.kopo.numberTicket.vo.ServiceDescVO;
import kr.ac.kopo.numberTicket.vo.UserTicketVO;

@Repository
public class NumberTicketDAOImpl implements NumberTicketDAO{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<NumberTicket_LatLngVO> selectLatLng() {
		List<NumberTicket_LatLngVO> LatLng = sqlSession.selectList("numberTicket.dao.NumberTicketDAO.selectLatLng");
		return LatLng;
	}

	@Override
	public List<NumberTicket_LatLngVO> selectList(String location) {
		List<NumberTicket_LatLngVO> BranchList = sqlSession.selectList("numberTicket.dao.NumberTicketDAO.selectBranchList", location);
		return BranchList;
	}

	@Override
	public NumberTicket_NumberTicketVO selectStandBy100(String location) {
		NumberTicket_NumberTicketVO nt100 = sqlSession.selectOne("numberTicket.dao.NumberTicketDAO.selectStandBy100", location);
		return nt100;
	}

	@Override
	public NumberTicket_NumberTicketVO selectStandBy200(String location) {
		NumberTicket_NumberTicketVO nt200 = sqlSession.selectOne("numberTicket.dao.NumberTicketDAO.selectStandBy200", location);
		return nt200;
	}
	
	@Override
	public NumberTicket_NumberTicketVO selectStandBy300(String location) {
		NumberTicket_NumberTicketVO nt300 = sqlSession.selectOne("numberTicket.dao.NumberTicketDAO.selectStandBy300", location);
		return nt300;
	}
	
	@Override
	public NumberTicket_NumberTicketVO selectStandBy400(String location) {
		NumberTicket_NumberTicketVO nt400 = sqlSession.selectOne("numberTicket.dao.NumberTicketDAO.selectStandBy400", location);
		return nt400;
	}

	@Override
	public NumberTicket_NumberTicketVO insertSelectNumberTicket(String locations, String service, HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("loginVO");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("locations", locations);
		map.put("service", service);
		map.put("id", user.getId());
		map.put("name", user.getName());
		sqlSession.insert("numberTicket.dao.NumberTicketDAO.insertNumberTicket", map);
		NumberTicket_NumberTicketVO nt = sqlSession.selectOne("numberTicket.dao.NumberTicketDAO.selectNumberTicket", map);
		System.out.println(locations);
		System.out.println(nt);
		return nt;
	}

	@Override
	public String selectServiceName(String service_id) {
		String service_name = sqlSession.selectOne("numberTicket.dao.NumberTicketDAO.selectService", service_id);
		return service_name;
	}

	@Override
	public List<ServiceDescVO> selectListServiceDesc() {
		return sqlSession.selectList("numberTicket.dao.NumberTicketDAO.selectListServiceDesc");
	}

	@Override
	public List<UserTicketVO> userTicket(String id) {
		return sqlSession.selectList("numberTicket.dao.NumberTicketDAO.userTicket",id);
	}

	@Override
	public List<AdminTicketVO> adminTicket(String tellerId) {
		return sqlSession.selectList("numberTicket.dao.NumberTicketDAO.adminTicket",tellerId);
	}
	
	@Override
	public List<AdminTicketVO> adminTicket100(String tellerId) {
		return sqlSession.selectList("numberTicket.dao.NumberTicketDAO.adminTicket100",tellerId);
	}
	@Override
	public List<AdminTicketVO> adminTicket200(String tellerId) {
		return sqlSession.selectList("numberTicket.dao.NumberTicketDAO.adminTicket200",tellerId);
	}
	@Override
	public List<AdminTicketVO> adminTicket300(String tellerId) {
		return sqlSession.selectList("numberTicket.dao.NumberTicketDAO.adminTicket300",tellerId);
	}
	@Override
	public List<AdminTicketVO> adminTicket400(String tellerId) {
		return sqlSession.selectList("numberTicket.dao.NumberTicketDAO.adminTicket400",tellerId);
	}

	@Override
	public int adminTicketUpdate(NumberTicket_NumberTicketVO vo) {
		return sqlSession.update("numberTicket.dao.NumberTicketDAO.adminTicketUpdate",vo);
	}

	@Override
	public NumberTicket_NumberTicketVO selectTicket(NumberTicket_NumberTicketVO vo) {
		return sqlSession.selectOne("numberTicket.dao.NumberTicketDAO.selectTicket",vo);
	}

	@Override
	public void insertAnalysis(AnalysisVO analysisvo) {
		sqlSession.insert("numberTicket.dao.NumberTicketDAO.insertAnalysis",analysisvo);
	}

	@Override
	public void deleteTicket(NumberTicket_NumberTicketVO vo) {
		sqlSession.delete("numberTicket.dao.NumberTicketDAO.deleteTicket",vo);
	}

	@Override
	public List<AnalysisVO> selectAnalysis(String tellerId) {
		return sqlSession.selectList("numberTicket.dao.NumberTicketDAO.selectAnalysis", tellerId);
	}

	@Override
	public void insertBasket(HttpSession session, String locations) {
		MemberVO user = (MemberVO)session.getAttribute("loginVO");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("locations", locations);
		map.put("id", user.getId());
		sqlSession.insert("numberTicket.dao.NumberTicketDAO.insertBasket",map);
	}

	@Override
	public List<BasketVO> selectBasketList(String id) {
		System.out.println("dao의"+id);
		List<BasketVO> basketList = sqlSession.selectList("numberTicket.dao.NumberTicketDAO.selectBasketList",id);
		System.out.println(basketList);
		return basketList;
	}

	@Override
	public AnalysisVO selectAnalysisTotal(String locations) {
		System.out.println(locations);
		AnalysisVO total = sqlSession.selectOne("numberTicket.dao.NumberTicketDAO.selectAnalysisTotal", locations);
		return total;
	}

	@Override
	public AnalysisVO selectAnalysis100(String locations) {
		AnalysisVO total = sqlSession.selectOne("numberTicket.dao.NumberTicketDAO.selectAnalysis100", locations);
		return total;
	}
	
	@Override
	public AnalysisVO selectAnalysis200(String locations) {
		AnalysisVO total = sqlSession.selectOne("numberTicket.dao.NumberTicketDAO.selectAnalysis200", locations);
		return total;
	}
	
	@Override
	public AnalysisVO selectAnalysis300(String locations) {
		AnalysisVO total = sqlSession.selectOne("numberTicket.dao.NumberTicketDAO.selectAnalysis300", locations);
		return total;
	}
	
	@Override
	public AnalysisVO selectAnalysis400(String locations) {
		AnalysisVO total = sqlSession.selectOne("numberTicket.dao.NumberTicketDAO.selectAnalysis400", locations);
		return total;
	}

	@Override
	public List<AnalysisVO> selectWeekVisit(String locations) {
		List<AnalysisVO> weekVisit = sqlSession.selectList("numberTicket.dao.NumberTicketDAO.selectWeekVisit", locations);
		return weekVisit;
	}

	@Override
	public void insertPreSubmit(HttpSession session, PreSubmitVO pre) {
		MemberVO loginVO = (MemberVO)session.getAttribute("loginVO");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", loginVO.getName());
		map.put("preSubmitBankName", pre.getPreSubmitBankName());
		map.put("preSubmitInputAccountNumber", pre.getPreSubmitInputAccountNumber());
		map.put("preSubmitCashInput", pre.getPreSubmitCashInput());
		map.put("preSubmitCheckInput", pre.getPreSubmitCheckInput());
		map.put("preSubmitMemo", pre.getPreSubmitMemo());
		map.put("serviceId", pre.getServiceId());
		map.put("serviceName", pre.getServiceName());
		map.put("branchName", pre.getBranchName());
		map.put("numberticketNumber", pre.getNumberticketNumber());
		sqlSession.insert("numberTicket.dao.NumberTicketDAO.insertPreSubmit",map);
		
	}

	@Override
	public List<PreSubmitVO> selectAllPre(String locations) {
		List<PreSubmitVO> preList = sqlSession.selectList("numberTicket.dao.NumberTicketDAO.selectAllPre", locations);
		return preList;
	}

	@Override
	public PreSubmitVO selectDetailByNo(int numberticketNumber, HttpSession session) {
		TellerVO loginVO = (TellerVO)session.getAttribute("loginVO");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("branchName", loginVO.getBranchName());
		map.put("numberticketNumber", numberticketNumber);
		PreSubmitVO pre = sqlSession.selectOne("numberTicket.dao.NumberTicketDAO.selectDetailByNo", map);
		return pre;
	}
	
	
	
}
