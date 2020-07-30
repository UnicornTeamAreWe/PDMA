import React from 'react';
import Plot from 'react-plotly.js';
import axios from "axios";
import qs from "qs";

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
            type: 'pie'
        }
    ];

    return (
        <div>
            <Plot
                data={data1}
                layout={ {width: 800, height: 600, title: 'Order Number By Month'} }
            />
            <Plot
                data={data2}
                layout={ {width: 800, height: 600, title: 'Order Number By Month'} }
            />
            <Plot
                data={data3}
                layout={ {width: 800, height: 600, title: 'Order Number By Month'} }
            />
        </div>);
}
