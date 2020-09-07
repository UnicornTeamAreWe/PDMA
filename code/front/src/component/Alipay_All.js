import React from 'react';
import Plot from 'react-plotly.js';
import axios from "axios";
import qs from "qs";
import { Typography, Divider } from 'antd';

const { Title, Paragraph, Text } = Typography;

const getAlipay = async (id,setData)=>{
    axios.post("http://localhost:8088/getAlipay", qs.stringify({ id: id }))
        .then(response =>{
            setData(response.data)
        })
        .catch(error=>console.log(error));
};

export function Alipay_All() {
    const [Alipay, setAlipay] = React.useState([]);

    React.useEffect(() => {
        getAlipay(1,(data)=>setAlipay(data)).catch()
    },[]);

    console.log(Alipay);
    let Net_income = 0;

    let Income_all = 0;
    let Spend_all = 0;
    let Calculate = () => {
        Income_all = 0;
        Spend_all = 0;
        Alipay.forEach(item =>{
            if (item.income_spending != null && item.income_spending.indexOf('收入') >= 0){
                Income_all += item.amount;
            }
            else if (item.income_spending != null && item.income_spending.indexOf('支出') >= 0){
                Spend_all += item.amount;
            }
        })
        Income_all = Income_all.toFixed(2);
        Spend_all = Spend_all.toFixed(2);
    }

    Calculate();
    Net_income = Income_all - Spend_all;
    let Income_Spend_arr = ['收入','支出'];
    let Income_Spend_amount = [Income_all,Spend_all];

    // let Min_time = Alipay[0].payment_time;
    // let Max_time = Alipay[(Alipay.length-1)].payment_time;
    // console.log(Min_time);
    // console.log(Max_time);

    let data1 = [
        {
            x: Income_Spend_arr,
            y: Income_Spend_amount,
            type: 'bar'
        }
    ];

    let data2 = [
        {
            labels: Income_Spend_arr,
            values: Income_Spend_amount,
            type: 'pie'
        }
    ];

    return (
        <div>
            <Plot
                data={data1}
                layout={ {width: 600, height: 400, title: 'Alipay Info'} }
            />
            <Plot
                data={data2}
                layout={ {width: 600, height: 400, title: 'Alipay Info'} }
            />
            <Typography>
                <Title>分析报告</Title>
                <Paragraph>
                    由图中内容可知，支付宝共收入{Income_all}元, 支出{Spend_all}元, 净收入{Net_income}元。
                </Paragraph>
            </Typography>
        </div>);
}
