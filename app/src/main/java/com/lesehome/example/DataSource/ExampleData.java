package com.lesehome.example.DataSource;

import com.lesehome.example.R;
import com.lesehome.example.bean.Item1Bean;
import com.lesehome.example.bean.Item2Bean;
import com.lesehome.example.bean.ItemAdvBean;
import com.lesehome.example.bean.ItemGroupContentBean;
import com.lesehome.example.bean.ItemGroupTitleBean;
import com.lesehome.modularrecyclerview.IHItemBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by hcp on 16/5/13.
 */
public class ExampleData {

    public static ItemAdvBean getItemAdv() {
//        String url = "http://img0.imgtn.bdimg.com/it/u=1988065642,368946272&fm=21&gp=0.jpg";
        String url = "http://c.hiphotos.baidu.com/zhidao/pic/item/8435e5dde71190efdcd27c34cb1b9d16fdfa6034.jpg";
        return new ItemAdvBean(url,
                "测试广告链接");
    }

    public static LinkedHashMap<ItemGroupTitleBean, LinkedList<ItemGroupContentBean>> getExample3() {
        LinkedHashMap<ItemGroupTitleBean, LinkedList<ItemGroupContentBean>> map = new LinkedHashMap<>();

        int mapSize = 5;
        for (int i = 1; i < mapSize; i++) {
            ItemGroupTitleBean key = new ItemGroupTitleBean("title[" + i + "]");

            LinkedList<ItemGroupContentBean> list = new LinkedList<>();
            int len = 11;
            for (int j = 1; j < len; j++) {
                list.add(new ItemGroupContentBean(key.title + "--(" + j + ")",
                        j + "内容的内容，测试数据，测试数据，测试数据，测试数据"));
            }
            map.put(key, list);
        }
        return map;
    }

    public static Map<IHItemBean, List<IHItemBean>> getExample2() {
        Map<IHItemBean, List<IHItemBean>> map = new HashMap<>();

        int mapSize = 5;
        for (int i = 1; i < mapSize; i++) {
            IHItemBean key = new ItemGroupTitleBean("第" + i + "分组的头部");
            List<IHItemBean> list = new ArrayList<>();
            int len = 9;
            for (int j = 1; j < len; j++) {
                list.add(new ItemGroupContentBean(
                        "第[" + i + "]分组内容的标题(" + j + ")", "内容的内容，测试数据，测试数据，测试数据，测试数据"));
            }
            map.put(key, list);
        }
        return map;
    }

    public static List<IHItemBean> getExample1() {

        List<IHItemBean> list = new ArrayList<>();

        list.add(new ItemAdvBean("http://img0.imgtn.bdimg.com/it/u=1988065642,368946272&fm=21&gp=0.jpg", "测试链接"));

        list.add(new Item1Bean("移轴摄影_百度百科", "移轴摄影，即移轴镜摄影（Tilt-shift photography），泛指利用移轴镜头创作的作品，所拍摄的照片效果就像是缩微模型一样，非常特别。移轴镜头的作用，本来主要是用来修正以普通..."));

        list.add(new Item2Bean(R.mipmap.ic_launcher, "标题1", "内容壹，测试数据111111111"));
        list.add(new Item2Bean(R.mipmap.ic_launcher, "标题2", "内容贰，测试数据222222222"));
        list.add(new Item1Bean("俯视角另类《侠盗猎车手5》短片 移轴摄影玩的爽", "今日,国外玩家放出了一段《侠盗猎车5》的最新短片,这位玩家别出心裁的使用了移轴摄影,配合动感的音乐,让整个《侠盗猎车5》的世界显得异常特别,十分... "));
        list.add(new Item2Bean(R.mipmap.ic_launcher, "标题3", "内容叁，测试数据333333333"));
        list.add(new Item2Bean(R.mipmap.ic_launcher, "标题4", "内容肆，测试数据444444444"));
        list.add(new Item2Bean(R.mipmap.ic_launcher, "标题5", "内容伍，测试数据555555555"));
        list.add(new Item2Bean(R.mipmap.ic_launcher, "标题6", "内容陆，测试数据666666666"));
        list.add(new Item1Bean("延时移轴摄影《迷你悉尼》", "澳大利亚的城市悉尼常常受到众多摄影爱好者的青睐,这座海滨之城总是散发着与众不同的迷人魅力。而 Filippo Rivetti 这部作品《Tiny Sydney》里镜头的创意切换,加上..."));
        list.add(new Item1Bean("芝加哥城市摄影 教科书式延时移轴摄影", "位于美国中西部的芝加哥和其郊区组成的大芝加哥地区是美国第三大都会区。在这部芝加哥的城市摄影作品中,运用了大量的延时摄影以及移轴摄影。现代动感的背景乐更好地..."));

        list.addAll(getItem1Bean());

        list.addAll(getItem2Bean());

        return list;
    }

    public static List<Item1Bean> getItem1Bean() {
        List<Item1Bean> list = new ArrayList<>();
        int item1BeanLen = 8;
        for (int i = 1; i <= item1BeanLen; i++) {
            list.add(new Item1Bean("+" + i + "芝加哥城市摄影 教科书式延时移轴摄影", "位于美国中西部的芝加哥和其郊区组成的大芝加哥地区是美国第三大都会区。在这部芝加哥的城市摄影作品中,运用了大量的延时摄影以及移轴摄影。现代动感的背景乐更好地..."));
        }
        return list;
    }

    public static List<Item2Bean> getItem2Bean() {
        List<Item2Bean> list = new ArrayList<>();
        int item2BeanLen = 9;
        for (int i = 1; i <= item2BeanLen; i++) {
            list.add(new Item2Bean(R.mipmap.ic_launcher, "标题" + i, "内容，测试数据" + (i * 9999)));
        }
        return list;
    }
}
