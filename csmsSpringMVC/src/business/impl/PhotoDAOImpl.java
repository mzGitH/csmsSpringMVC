package business.impl;

import model.TPhoto;

import org.springframework.stereotype.Component;

import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.PhotoDAO;

@Component("photodao")
public class PhotoDAOImpl implements PhotoDAO {
	private iHibBaseDAO bdao;

	public PhotoDAOImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Override
	public TPhoto getPhotoById(int id) {
		return (TPhoto) bdao.findById(TPhoto.class, id);
	}

	@Override
	public int addPhoto(TPhoto obj) {
		int res = (int) bdao.insert(obj);
		if (res>0) {
			return res;
		}
		return 0;
	}

	@Override
	public boolean deletePhoto(int id) {
		TPhoto photo = (TPhoto) bdao.findById(TPhoto.class, id);
		return bdao.delete(photo);
	}

}
