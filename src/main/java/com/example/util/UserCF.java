package com.example.util;

import java.util.*;
import java.util.Map.Entry;

/**
 * 基于用户的协同过滤推荐算法实现
 A a b d
 B a c
 C b e
 D c d e
 * @author Administrator
 *
 */
public class UserCF {
    public static void main(String[] args) {
        /**
         * 输入用户-->物品条目 一个用户对应多个物品
         * 用户ID 商家ID集合
         * Customer1  M1 M2 M4
         * Customer2  M1 M3
         * Customer3  M2 M5
         * Customer4  M3 M4 M5
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the total users number:");
        //输入用户总量
        int N = scanner.nextInt();
        int[][] sparseMatrix = new int[N][N];
        //建立用户稀疏矩阵，用于用户相似度计算【相似度矩阵】
        Map<String, Integer> userMerchantLength = new HashMap<>();
        //存储每一个用户对应的不同商家总数 eg: Customer1 3
        Map<String, Set<String>> merchantUserCollection = new HashMap<>();
        //建立商家到用户的倒排表 eg: M1 Customer1 Customer2
        Set<String> merchants = new HashSet<>();
        //辅助存储商家ID集合
        Map<String, Integer> userID = new HashMap<>();
        //辅助存储每一个用户的用户ID映射
        Map<Integer, String> idUser = new HashMap<>();
        //辅助存储每一个ID对应的用户映射
        System.out.println("Input user--merchants maping infermation:<eg:A a b d>");
        scanner.nextLine();
        for (int i = 0; i < N ; i++){
            //依次处理N个用户 输入数据 以空格间隔
            String[] user_merchant = scanner.nextLine().split(" ");
            int length = user_merchant.length;
            userMerchantLength.put(user_merchant[0], length-1);
            //eg: Customer1 3
            userID.put(user_merchant[0], i);
            //用户ID与稀疏矩阵建立对应关系
            idUser.put(i, user_merchant[0]);
            //建立商家--用户倒排表
            for (int j = 1; j < length; j ++){
                if(merchants.contains(user_merchant[j])){
                    //如果已经包含对应的商家--用户映射，直接添加对应的用户
                    merchantUserCollection.get(user_merchant[j]).add(user_merchant[0]);
                } else{
                    //否则创建对应商家--用户集合映射
                    merchants.add(user_merchant[j]);
                    merchantUserCollection.put(user_merchant[j], new HashSet<String>());
                    //创建商家--用户倒排关系
                    merchantUserCollection.get(user_merchant[j]).add(user_merchant[0]);
                }
            }
        }
        System.out.println(merchantUserCollection.toString());
        //计算相似度矩阵【稀疏】
        Set<Entry<String, Set<String>>> entrySet = merchantUserCollection.entrySet();
        Iterator<Entry<String, Set<String>>> iterator = entrySet.iterator();
        while(iterator.hasNext()){
            Set<String> commonUsers = iterator.next().getValue();
            for (String user_u : commonUsers) {
                for (String user_v : commonUsers) {
                    if(user_u.equals(user_v)){
                        continue;
                    }
                    sparseMatrix[userID.get(user_u)][userID.get(user_v)] += 1;
                    //计算用户u与用户v都购买过的的商家总数
                }
            }
        }
        System.out.println(userMerchantLength.toString());
        System.out.println("Input the user for recommendation:<eg:Customer1>");
        String recommendCustomer = scanner.nextLine();
        System.out.println(userID.get(recommendCustomer));
        //计算用户之间的相似度【余弦相似性】
        int recommendCustomerId = userID.get(recommendCustomer);
        for (int j = 0;j < sparseMatrix.length; j++) {
            if(j != recommendCustomerId){
                System.out.println(idUser.get(recommendCustomerId)+"--"+idUser.get(j)+"similarity:"+sparseMatrix[recommendCustomerId][j]/Math.sqrt(userMerchantLength.get(idUser.get(recommendCustomerId))*userMerchantLength.get(idUser.get(j))));
            }
            //string RecommendMerchant = max()
        }
        /*
        //计算指定用户recommendCustomer的物品推荐度
        for (String item: merchants){
            //遍历每一个商家
            Set<String> users = merchantUserCollection.get(item);
            //得到在商家下单过的所有用户集合
            if(!users.contains(recommendCustomer)){
                //如果被推荐用户没有在商家下单，则进行推荐度计算
                double itemRecommendDegree = 0.0;
                for (String user: users){
                    itemRecommendDegree += sparseMatrix[userID.get(recommendCustomer)][userID.get(user)]/Math.sqrt(userMerchantLength.get(recommendCustomer)*userMerchantLength.get(user));
                    //推荐度计算
                }
                System.out.println("The merchant "+item+" for "+recommendCustomer +"'s recommended degree:"+itemRecommendDegree);
            }
        }
        */
        scanner.close();
    }
}