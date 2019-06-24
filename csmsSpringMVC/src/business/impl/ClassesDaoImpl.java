package business.impl;

import java.util.List;

import model.TClass;
import model.VClass;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.ClassesDAO;

public class ClassesDaoImpl implements ClassesDAO {

	private iHibBaseDAO bdao;

	public void setBdao(iHibBaseDAOImpl bdao) {
		this.bdao = bdao;
	}

	// public ClassesDaoImpl() {
	// bdao = new iHibBaseDAOImpl();
	// }

	@Override
	public boolean insert(TClass classes) {
		int row = (Integer) bdao.insert(classes);
		if (row > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int classid) {
		TClass cla = (TClass) bdao.findById(TClass.class, classid);
		return bdao.delete(cla);
	}

	@Override
	public TClass selectByid(int classid) {
		TClass cla = (TClass) bdao.findById(TClass.class, classid);
		return cla;
	}

	@Override
	public List<TClass> select() {
		String hql = "from TClass";
		List<TClass> list = (List<TClass>) bdao.select(hql);
		return list;
	}

	@Override
	public List<TClass> selectByMajor(int majorid) {
		String hql = "from TClass where majorid=?";
		Object[] para = { majorid };
		List<TClass> list = (List<TClass>) bdao.select(hql, para);
		return list;
	}

	// public static void main(String[] args){
	// ClassesDAO dao = new ClassesDaoImpl();
	// List<VClass> list = dao.selectByCollegeVclass(5);
	// for(VClass cl:list){
	// System.out.println(cl.getClassname());
	// }
	// }

	@Override
	public VClass selectByidVclass(int classid) {
		VClass cla = (VClass) bdao.findById(VClass.class, classid);
		return cla;
	}

	@Override
	public List<VClass> selectVclass() {
		String hql = "from VClass";
		List<VClass> list = (List<VClass>) bdao.select(hql);
		return list;
	}

	@Override
	public List<VClass> selectByMajorVclass(int majorid) {
		String hql = "from VClass where majorid=?";
		Object[] para = { majorid };
		List<VClass> list = (List<VClass>) bdao.select(hql, para);
		return list;
	}

	@Override
	public List<VClass> selectByCollegeVclass(int collegeid) {
		String hql = "from VClass where collegeid=?";
		Object[] para = { collegeid };
		List<VClass> list = (List<VClass>) bdao.select(hql, para);
		return list;
	}
}
