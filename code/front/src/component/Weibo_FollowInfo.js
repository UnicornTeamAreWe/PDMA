import React from 'react';
import Plot from 'react-plotly.js';
import axios from "axios";
import qs from "qs";
import { Typography, Divider } from 'antd';

const { Title, Paragraph, Text } = Typography;

const getWeibo = async (id,setData)=>{
    axios.post("http://localhost:8088/getWeibo", qs.stringify({ id: id }))
        .then(response =>{
            setData(response.data)
        })
        .catch(error=>console.log(error));
};

export function Weibo_FollowInfo() {
    const [Weibo, setWeibo] = React.useState([]);

    React.useEffect(() => {
        getWeibo(1,(data)=>setWeibo(data)).catch()
    },[]);

    console.log(Weibo);
    let Info_arr = ['未分组', '脱口秀','电影', '体育', '美','游戏', '数码', '摄影','情感', '宠物', '公安','动漫', '明星', '名人','同事', '同学'];
    let Info = [];
    Info.push(Weibo.unclassified);
    Info.push(Weibo.cross_talk);
    Info.push(Weibo.movie);
    Info.push(Weibo.sports);
    Info.push(Weibo.beauty);
    Info.push(Weibo.game);
    Info.push(Weibo.digital);
    Info.push(Weibo.photography);
    Info.push(Weibo.emotion);
    Info.push(Weibo.pet);
    Info.push(Weibo.police);
    Info.push(Weibo.cartoon);
    Info.push(Weibo.star);
    Info.push(Weibo.celebrity);
    Info.push(Weibo.colleague);
    Info.push(Weibo.classmate);

    let perc = [];
    let j = 0;
    let Percent = ()=>{
        j = 0;
        Info.forEach(item=>{
            perc.push((Info[j]*100/Weibo.follow).toFixed(2));
            j++;
        })

    }
    Percent();

    let str="";
    let i = 0;
    let Content = ()=>{
        i = 0;
        Info_arr.forEach(item=>{
            str += item + Info[i] + "人, 占比"+ perc[i] +"%,";
            i++;
        })
    }
    Content();

    let data1 = [
        {
            x: Info_arr,
            y: Info,
            type: 'bar'
        }
    ];

    let data2 = [
        {
            labels: Info_arr,
            values: Info,
            type: 'pie'
        }
    ];

    return (
        <div>
            <Plot
                data={data1}
                layout={ {width: 600, height: 400, title: 'Weibo Follow Info'} }
            />
            <Plot
                data={data2}
                layout={ {width: 600, height: 400, title: 'Weibo Follow Info'} }
            />
            <Typography>
                <Title>分析报告</Title>
                <Paragraph>
                    由图中内容可知，微博共关注{Weibo.follow}人，其中{str}。
                </Paragraph>
            </Typography>
        </div>);
}
