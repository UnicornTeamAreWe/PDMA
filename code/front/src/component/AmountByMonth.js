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

export function AmountByMonth() {
    const [Taobao, setTaobao] = React.useState([]);

    React.useEffect(() => {
        getTaobaoAnalysis(1,(data)=>setTaobao(data)).catch()
    },[]);

    console.log(Taobao);
    let Month_arr = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
    let AmountByMonth = Array.from({length:12}).fill(0)
    let Amount = () =>{
        Taobao.forEach(item =>{
            AmountByMonth[item.month-1] += item.amount;
        });
    }
    Amount();
    let maxNum = Math.max.apply(null,AmountByMonth);
    let minNum = Math.min.apply(null,AmountByMonth);
    let Max_month = AmountByMonth.findIndex((item) => item === maxNum)+1;
    let Min_month = AmountByMonth.findIndex((item) => item === minNum)+1;
    let all = eval(AmountByMonth.join("+"));
    let average = (all/12).toFixed(2);

    let data1 = [
        {
            x: Month_arr,
            y: AmountByMonth,
            type: 'bar'
        }
    ];

    let data2 = [
        {
            x: Month_arr,
            y: AmountByMonth,
            type: 'scatter'
        }
    ];

    let data3 = [
        {
            values: AmountByMonth,
            labels: Month_arr,
            type: 'pie',
            hole: .4
        }
    ];

    return (
        <div>
            <Plot
                data={data1}
                layout={ {width: 600, height: 400, title: 'Amount By Month'} }
            />
            <Plot
                data={data2}
                layout={ {width: 600, height: 400, title: 'Amount By Month'} }
            />
            <Plot
                data={data3}
                layout={ {width: 600, height: 400, title: 'Amount By Month'} }
            />
            <Typography>
                <Title>分析报告</Title>
                <Paragraph>
                    图中展示了您在淘宝上每个月消费的金额，您可以从中获知每个月消费金额的大小。由图可知，消费金额最多的月份为{Max_month}月份，共消费{maxNum}元，消费金额最少的月份为{Min_month}月份，共消费{minNum}元, 平均每个月消费{average}元。
                </Paragraph>
            </Typography>
        </div>);
}
