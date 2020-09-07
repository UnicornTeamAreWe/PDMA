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

export function AmountByYear() {
    const [Taobao, setTaobao] = React.useState([]);

    React.useEffect(() => {
        getTaobaoAnalysis(1,(data)=>setTaobao(data)).catch()
    },[]);

    let min = Math.min.apply(Math, Taobao.map(item=> {return item.year}));
    let Year = new Date().getFullYear();
    let Gap = Year - min;
    let AmountByYear = Array.from({length:Gap+1}).fill(0)
    let year_arr = [];
    let Amount = () =>{
        Taobao.forEach(item =>{
            AmountByYear[2020-item.year] += item.amount;
        });
        for (let i = 0; i <= Gap; ++i){
            let y = Year-i;
            year_arr.push(y.toString());
        }
    }
    Amount();
    let maxNum = Math.max.apply(null,AmountByYear);
    let minNum = Math.min.apply(null,AmountByYear);
    let Max_year = Year-AmountByYear.findIndex((item) => item === maxNum);
    let Min_year = Year-AmountByYear.findIndex((item) => item === minNum);
    let all = eval(AmountByYear.join("+"));
    let average = (all/AmountByYear.length).toFixed(2);

    let data1 = [
        {
            x: year_arr,
            y: AmountByYear,
            type: 'bar'
        }
    ];

    let data2 = [
        {
            x: year_arr,
            y: AmountByYear,
            type: 'scatter'
        }
    ];

    let data3 = [
        {
            values: AmountByYear,
            labels: year_arr,
            type: 'pie',
            hole: .4
        }
    ];

    return (
        <div>
            <Plot
                data={data1}
                layout={ {width: 600, height: 400, title: 'Amount By Year'} }
            />
            <Plot
                data={data2}
                layout={ {width: 600, height: 400, title: 'Amount By Year'} }
            />
            <Plot
                data={data3}
                layout={ {width: 600, height: 400, title: 'Amount By Year'} }
            />
            <Typography>
                <Title>分析报告</Title>
                <Paragraph>
                    图中展示了您在淘宝上每年消费的金额，您可以从中获知每年消费金额的大小。由图可知，消费金额最多的年份为{Max_year}年，共消费{maxNum.toFixed(2)}元，消费金额最少的年份为{Min_year}年，共消费{minNum.toFixed(2)}元, 平均每年消费{average}元。
                </Paragraph>
            </Typography>
        </div>
        );
}
