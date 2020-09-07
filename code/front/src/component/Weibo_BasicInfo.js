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

export function Weibo_BasicInfo() {
    const [Weibo, setWeibo] = React.useState([]);

    React.useEffect(() => {
        getWeibo(1,(data)=>setWeibo(data)).catch()
    },[]);

    console.log(Weibo);
    let Info_arr = ['粉丝数', '关注数', '发微博数'];
    let Info = [];
    Info.push(Weibo.fans);
    Info.push(Weibo.follow);
    Info.push(Weibo.wb);


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
                layout={ {width: 600, height: 400, title: 'Weibo Basic Info'} }
            />
            <Plot
                data={data2}
                layout={ {width: 600, height: 400, title: 'Weibo Basic Info'} }
            />
            <Typography>
                <Title>分析报告</Title>
                <Paragraph>
                    由图中内容可知，微博共关注{Weibo.follow}人，发过{Weibo.wb}条微博，拥有{Weibo.fans}位粉丝。
                </Paragraph>
            </Typography>
        </div>);
}
