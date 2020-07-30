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
    console.log(AmountByMonth);

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
            type: 'pie'
        }
    ];

    return (
        <div>
            <Plot
                data={data1}
                layout={ {width: 800, height: 600, title: 'Amount By Month'} }
            />
            <Plot
                data={data2}
                layout={ {width: 800, height: 600, title: 'Amount By Month'} }
            />
            <Plot
                data={data3}
                layout={ {width: 800, height: 600, title: 'Amount By Month'} }
            />
        </div>);
}
