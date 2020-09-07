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

export function OrderNumberByMonth() {
    const [Taobao, setTaobao] = React.useState([]);

    React.useEffect(() => {
        getTaobaoAnalysis(1,(data)=>setTaobao(data)).catch()
    },[]);

    console.log(Taobao);
    let Month_arr = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
    let OrderNumberByMonth = Array.from({length:12}).fill(0)
    let Number = () =>{
        Taobao.forEach(item =>{
            OrderNumberByMonth[item.month-1] += item.order_number;
        });
    }
    Number();
    console.log(OrderNumberByMonth);

    let maxNum = Math.max.apply(null,OrderNumberByMonth);
    let minNum = Math.min.apply(null,OrderNumberByMonth);
    let Max_month = OrderNumberByMonth.findIndex((item) => item === maxNum)+1;
    let Min_month = OrderNumberByMonth.findIndex((item) => item === minNum)+1;
    let all = eval(OrderNumberByMonth.join("+"));
    let average = (all/12).toFixed(2);


    let data1 = [
        {
            x: Month_arr,
            y: OrderNumberByMonth,
            type: 'bar'
        }
    ];

    let data2 = [
        {
            x: Month_arr,
            y: OrderNumberByMonth,
            type: 'scatter'
        }
    ];

    let data3 = [
        {
            labels: Month_arr,
            values: OrderNumberByMonth,
            type: 'pie',
            hole: .4
        }
    ];

    return (
        <div>
            <Plot
                data={data1}
                layout={ {width: 600, height: 400, title: 'Order Number By Month'} }
            />
            <Plot
                data={data2}
                layout={ {width: 600, height: 400, title: 'Order Number By Month'} }
            />
            <Plot
                data={data3}
                layout={ {width: 600, height: 400, title: 'Order Number By Month'} }
            />
            <Typography>
                <Title>分析报告</Title>
                <Paragraph>
                    图中展示了您在淘宝上每个月订单的数量，您可以从中获知每个月消费数量的大小。由图可知，消费订单数最多的月份为{Max_month}月份，共消费{maxNum}笔，消费订单数最少的月份为{Min_month}月份，共消费{minNum}笔, 平均每个月消费{average}笔。
                </Paragraph>
            </Typography>
        </div>);
}
