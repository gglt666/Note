package pers.gglt.project.esptouch;

public interface IHexMsg {
    //接口会自动将成员变量设置为静态的（static）、不可变的（final）
    String openRelay1 = "A00101A2";
    String openRelay2 = "A00201A3";
    String openRelay3 = "A00301A4";
    String openRelay4 = "A00401A5";
    String closeRelay1 = "A00100A1";
    String closeRelay2 = "A00200A2";
    String closeRelay3 = "A00300A3";
    String closeRelay4 = "A00400A4";
}