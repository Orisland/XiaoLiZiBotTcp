package wows;

public interface WowsInfos {

    String getUserId(String username);

    player getUserBasicInfo(String uid);

    String getShipInfo(Long uid);

}
