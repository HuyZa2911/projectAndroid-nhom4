//package com.example.quanlykhachsan.models_manage_data;
//
//import com.example.quanlykhachsan.models_data.DatPhong;
//import com.example.quanlykhachsan.models_data.Phong;
//
//import java.util.ArrayList;
//
//public class ListDatPhong {
//    private ArrayList<DatPhong> listDatPhongs;
//
//    public void updateDatPhong(DatPhong datPhong){
//        for (DatPhong phong:listDatPhongs){
//            if (phong.getIdDatPhong()==datPhong.getIdDatPhong()){
//                phong.setTaiKhoan(datPhong.getTaiKhoan());
//                phong.setdTienCoc(datPhong.getdTienCoc());
//                phong.setIdPhong(datPhong.getIdPhong());
//                phong.setdTongTien(datPhong.getdTongTien());
//                phong.setNgayThue(datPhong.getNgayThue());
//                phong.setNgayTra(datPhong.getNgayTra());
//                phong.setThoiGianDat(datPhong.getThoiGianDat());
//                phong.setThoiGianThue(datPhong.getThoiGianThue());
//                phong.setTrangThai(datPhong.getTrangThai());
//                break;
//            }
//        }
//    }
//    public void deleteDatPhong(DatPhong datPhong){
//        for (DatPhong phong:listDatPhongs){
//            if (phong.getIdDatPhong()==datPhong.getIdDatPhong()){
//                listDatPhongs.remove(datPhong);
//                break;
//            }
//        }
//    }
//    public void addDatPhong(DatPhong datPhong){
//        listDatPhongs.add(datPhong);
//    }
//    public ArrayList<DatPhong> getListDatPhongs() {
//        return listDatPhongs;
//    }
//
//    public void setListDatPhongs(DatPhong... datPhongs) {
//        for (DatPhong datPhong : datPhongs) {
//            this.listDatPhongs.add(datPhong);
//        }
//
//    }
//
//
//}
