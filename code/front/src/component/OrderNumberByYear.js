import React from 'react';
import Plot from 'react-plotly.js';
import axios from "axios";
import qs from "qs";
import {Typography} from "antd";

const { Title, Paragraph, Text } = Typography;
const getTaobaoAnalysis = async (id,setData)=>{
    axios.post("http://localhost:8088/getTaobaoAnalysis", qs.stringify({ id: id }))
        .then(response =>{
            setData(response.data)
        })
        .catch(error=>console.log(error));
};

export function OrderNumberByYear() {
    const [Taobao, setTaobao] = React.useState([]);

    React.useEffect(() => {
        getTaobaoAnalysis(1,(data)=>setTaobao(data)).catch()
    },[]);

    let min = Math.min.apply(Math, Taobao.map(item=> {return item.year}));
    let Year = new Date().getFullYear();
    let Gap = Year - min;
    let OrderNumberByYear = Array.from({length:Gap+1}).fill(0)
    let year_arr = [];
    let Number = () =>{
        Taobao.forEach(item =>{
            OrderNumberByYear[2020-item.year] += item.order_number;
        });
        for (let i = 0; i <= Gap; ++i){
            let y = Year-i;
            year_arr.push(y.toString());
        }
    }
    Number();

    let maxNum = Math.max.apply(null,OrderNumberByYear);
    let minNum = Math.min.apply(null,OrderNumberByYear);
    let Max_year = Year-OrderNumberByYear.findIndex((item) => item === maxNum);
    let Min_year = Year-OrderNumberByYear.findIndex((item) => item === minNum);
    let all = eval(OrderNumberByYear.join("+"));
    let average = (all/OrderNumberByYear.length).toFixed(2);

    let data1 = [
        {
            x: year_arr,
            y: OrderNumberByYear,
            type: 'bar'
        }
    ];

    let data2 = [
        {
            x: year_arr,
            y: OrderNumberByYear,
            type: 'scatter'
        }
    ];

    let data3 = [
        {
            labels:  year_arr,
            values: OrderNumberByYear,
            type: 'pie',
            hole: .4
        }
    ];

    return (
        <div>
            <Plot
                data={data1}
                layout={ {width: 600, height: 400, title: 'Order Number By Year'} }
            />
            <Plot
                data={data2}
                layout={ {width: 600, height: 400, title: 'Order Number By Year'} }
            />
            <Plot
                data={data3}
                layout={ {width: 600, height: 400, title: 'Order Number By Year'} }
            />
            <Typography>
                <Title>分析报告</Title>
                <Paragraph>
                    图中展示了您在淘宝上每年订单的数量，您可以从中获知每年消费数量的大小。由图可知，消费订单数最多的年份为{Max_year}年，共消费{maxNum}笔，消费订单数最少的年份为{Min_year}年，共消费{minNum}笔, 平均每年消费{average}笔。
                </Paragraph>
            </Typography>
        </div>);
}
