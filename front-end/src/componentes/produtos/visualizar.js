import React, {useState, useEffect} from 'react';
import { useParams, useHistory } from "react-router-dom";

import { LinkContainer } from 'react-router-bootstrap';
import Card from 'react-bootstrap/Card';

import { ajax } from "rxjs/ajax";
import { map } from "rxjs/operators";
import { BASE_URL, API_ENDPOINTS } from '../../endpoints';
import Axios from 'axios';

function VisualizarProduto() {
  const {idProduto} = useParams();
  const [produto, setProduto] = useState({});

  useEffect(() => {
    ajax(`${BASE_URL + API_ENDPOINTS.product}/${idProduto}`)
      .pipe(map((ajaxResponse) => ajaxResponse.response))
      .subscribe((x) => setProduto(x))
  }, [idProduto]);

  const formataDinheiro = (valor) => {
    if (valor !== undefined) {
      return 'R$ ' + parseFloat(valor).toFixed(2).replace('.',',');
    }
    
    return 'R$ 0,00';
  };
  
  const removerProduto = (evento) => {
    evento.preventDefault();
    Axios.delete(`${BASE_URL + API_ENDPOINTS.product}/${idProduto}`);
  };

  return (
    <Card className="detalheProduto">
      <Card.Img variant="top" src={produto.image} alt="Foto do Produto" />
      <Card.Body>
        <Card.Title>{produto.name}</Card.Title>
        <Card.Text>
          Preço: {formataDinheiro(produto.value)}
        </Card.Text>
      </Card.Body>
      <Card.Body>
        <LinkContainer to={'/produtos/editar/' + idProduto}>
          <Card.Link className="btn btn-primary" href="#">Editar</Card.Link>
        </LinkContainer>
        <Card.Link onClick={(e) => removerProduto(e)} className="btn btn-danger" href="#">Remover</Card.Link>
      </Card.Body>        
    </Card>
  );
}

export default VisualizarProduto;