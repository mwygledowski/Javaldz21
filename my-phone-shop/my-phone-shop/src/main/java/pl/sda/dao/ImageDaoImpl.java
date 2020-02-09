package pl.sda.dao;

public class ImageDaoImpl implements ImageDao {
    @Override
    public String getImagePath(Long productId) {
        return "/image/iphone.png";
    }
}
